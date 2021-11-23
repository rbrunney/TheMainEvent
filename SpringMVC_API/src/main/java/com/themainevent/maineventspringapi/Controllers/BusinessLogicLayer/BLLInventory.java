package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelInventory;
import com.themainevent.maineventspringapi.Repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BLLInventory {

    @Autowired
    private InventoryRepository inventoryRepo;

    public String addToInventory(ModelInventory inventory){

        try{
            inventoryRepo.save(inventory);
            return "Item added to inventory.";
        }catch(Exception e){
            e.printStackTrace();
            return "Item could not be added to inventory.";
        }
    }

    //Find By Name
    public List<ModelInventory> getByFirstName(String name){
        return inventoryRepo.findByName(name);
    }

    //Delete
    public String Delete(String name){
        try {
            inventoryRepo.deleteByName(name);
            return "Inventory item has been deleted";
        }catch (Exception e){
            e.printStackTrace();
            return "Inventory Item could not be Deleted";
        }
    }

    //Update
    public String updateInventory(String name, String newName){
        try {
            List<ModelInventory> inventory = inventoryRepo.findByName(name);

            return "Inventory has been Updated";
        }catch (Exception e){
            e.printStackTrace();
            return "Inventory could not be Updated";
        }
    }
}
