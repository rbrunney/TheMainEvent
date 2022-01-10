package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLIngredient;
import com.themainevent.maineventspringapi.Models.ModelIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ingredient")
@CrossOrigin(origins = "http://localhost:3000")
public class IngredientController {
    @Autowired
    private BLLIngredient bllIngredient;

    @GetMapping(path="/getAll")
    public void getAll() {
        bllIngredient.getAll();
    }

    @PostMapping(path="/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String add(@RequestBody ModelIngredient ingredient) {
        //Test/Validate Values
        System.out.println("[INGREDIENT INFO] Name: " + ingredient.getName());

        return bllIngredient.addIngredient(ingredient);
    }
    @DeleteMapping(path = "/delete/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public String delete(@PathVariable String name){return bllIngredient.Delete(name);}

//    @PutMapping(path = "/update/{oldName}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public String update(@PathVariable String oldName, @RequestBody ModelIngredient newName){return bllIngredient.updateIngredient(oldName, newName);}

    @GetMapping(path = "/search/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ModelIngredient> read(@PathVariable String name) {return bllIngredient.getByName(name);}
}
