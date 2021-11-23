package com.themainevent.maineventspringapi.Controllers.Mapping;


import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLMenuItem;
import com.themainevent.maineventspringapi.Models.ModelMenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/menuItem")
public class MenuItemController {

    @Autowired
    private BLLMenuItem bllMenuItem;

    //Checking the pathing
    @GetMapping(path="/check")
    public String check() {
        return "Hello from Menu Item Controller";
    }

    //Add Menu Items to DB
    @PostMapping(path="/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String add(@RequestBody ModelMenuItem menuItem) {
        //Test/Validate Values
        System.out.println("[Menu Item INFO] Name: " + menuItem.getIngredients());

        return bllMenuItem.addMenuItem(menuItem);
    }

    @DeleteMapping(path = "/delete/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public String delete(@PathVariable String name){return bllMenuItem.Delete(name);}

    @PutMapping(path = "/update/{oldName}/{newName}")
    @ResponseStatus(code = HttpStatus.OK)
    public String update(@PathVariable String newName, @PathVariable String oldName){
        return bllMenuItem.updateMenuItem(oldName, newName);
    }

    @GetMapping(path = "/search/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ModelMenuItem> read(@PathVariable String name) {
        return bllMenuItem.getByFirstName(name);
    }
}