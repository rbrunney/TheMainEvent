package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelIngredient;
import com.themainevent.maineventspringapi.Repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BLLIngredient {

    @Autowired
    private IngredientRepository ingredientRepo;

//    public List<ModelIngredient> getByFirstName(String name){
//        return ingredientRepo.findFirstByName(name);
//    }
}
