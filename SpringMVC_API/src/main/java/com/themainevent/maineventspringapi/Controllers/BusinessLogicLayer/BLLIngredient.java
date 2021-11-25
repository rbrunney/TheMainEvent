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
        return ingredientRepo.findById(id);
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
//            List<ModelIngredient> ingredient = ingredientRepo.findByIdAndName(oldIngredient.getId(), ingredientRepo.findByName(oldIngredient.getName()));
//            ingredient.setName(newIngredient.getName());
//            ingredientRepo.save(ingredient);
            return "Ingredient has been Updated";
        }catch (Exception e){
            e.printStackTrace();
            return "Ingredient could not be Updated";
        }
    }

}
