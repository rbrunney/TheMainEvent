package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLIngredient;
import com.themainevent.maineventspringapi.Models.ModelIngredient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredient")
public class Ingredientmapping {
    BLLIngredient bllIngredient = new BLLIngredient();

    @GetMapping(path = "/findFirstByName/{name}")
    @ResponseBody
    public List<ModelIngredient> getFirstIngredientName(@PathVariable String name){return bllIngredient.getByFirstName(name);}


}
