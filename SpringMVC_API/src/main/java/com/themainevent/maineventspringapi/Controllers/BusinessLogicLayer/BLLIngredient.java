package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelIngredient;
import com.themainevent.maineventspringapi.Repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

//  //////////////////////////////////////////////
    //Find By Name
    public List<ModelIngredient> getByFirstName(String name){
        return ingredientRepo.findByName(name);
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
    public String updateIngredient(String oldIngredient, ModelIngredient newIngredient){
        try {
            ModelIngredient ingredient = ingredientRepo.findFirstByName(oldIngredient);
            ingredient.setName(newIngredient.getName());
            ingredientRepo.save(ingredient);
            return "Ingredient has been Updated";
        }catch (Exception e){
            e.printStackTrace();
            return "Ingredient could not be Updated";
        }
    }

}
