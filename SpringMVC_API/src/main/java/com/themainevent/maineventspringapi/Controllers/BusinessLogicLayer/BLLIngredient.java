package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelIngredient;
import com.themainevent.maineventspringapi.Repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BLLIngredient {

    @Autowired
    private IngredientRepository ingredientRepo;

    public String addIngredient(ModelIngredient ingredient) {
        try {
            ingredientRepo.save(ingredient);
            return "Ingredient has been saved";
        } catch(Exception e) {
            e.printStackTrace();
            return "Ingredient could not be saved";
        }
    }

    public void getAll(){
        System.out.println("Ingredients found with findAll():");
        System.out.println("-------------------------------");
        for (ModelIngredient ingredient : ingredientRepo.findAll()){
            System.out.println(ingredient);

        }
    }

//  //////////////////////////////////////////////
    //Find By ID
    public Optional<ModelIngredient> getById(String id){
        return ingredientRepo.findBy_id(id);
    }

    //Find By Name
    public List<ModelIngredient> getByName(String name){

        List<ModelIngredient> foundNames= ingredientRepo.findAllByName(name);
        for (ModelIngredient ingredient : foundNames) {
            System.out.println(ingredient);
        }
        return foundNames;
    }

    //Delete
    public String Delete(String name){
        try {
            ingredientRepo.deleteByName(name);
            return "Ingredient has been deleted";
        }catch (Exception e){
            e.printStackTrace();
            return "Ingredient could not be Deleted";
        }
    }

    //Update
    public String updateIngredient(ModelIngredient oldIngredient, ModelIngredient newIngredient){
        try {
            Optional<ModelIngredient> ingredient = ingredientRepo.findBy_id(oldIngredient.get_id());
            if (ingredient.isPresent()){
                ingredient.get().setName(newIngredient.getName());
            }
            ingredientRepo.save(newIngredient);
            return "Ingredient has been Updated";
        }catch (Exception e){
            e.printStackTrace();
            return "Ingredient could not be Updated";
        }
    }

}
