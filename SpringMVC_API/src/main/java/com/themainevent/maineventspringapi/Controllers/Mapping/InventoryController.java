package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLInventory;
import com.themainevent.maineventspringapi.Models.ModelInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/inventory")
public class InventoryController {

    @Autowired
    private BLLInventory bllInventory;

    @GetMapping(path="/check")
    public String check() {
        return "Hello from Inventory Controller";
    }

    @PostMapping(path="/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String add(@RequestBody ModelInventory inventory) {
        //Test/Validate Values
        System.out.println("[INGREDIENT INFO] Name: " + inventory.getIngredient().getName());

        return bllInventory.addToInventory(inventory);
    }

    @DeleteMapping(path = "/delete/{inventory}")
    @ResponseStatus(code = HttpStatus.OK)
    public String delete(@PathVariable ModelInventory inventory){return bllInventory.Delete(inventory);}

    @PutMapping(path = "/update/{oldInventory}")
    @ResponseStatus(code = HttpStatus.OK)
    public String update(@PathVariable ModelInventory oldInventory, @RequestBody ModelInventory newInventory){
        return bllInventory.updateInventory(oldInventory, newInventory);
    }

    @GetMapping(path = "/search/{Inventory}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ModelInventory> read(@PathVariable ModelInventory Inventory) {
        return bllInventory.getByIngredient(Inventory);
    }
}
