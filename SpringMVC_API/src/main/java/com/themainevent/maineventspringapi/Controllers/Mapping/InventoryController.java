package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLInventory;
import com.themainevent.maineventspringapi.Models.ModelIngredient;
import com.themainevent.maineventspringapi.Models.ModelInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
