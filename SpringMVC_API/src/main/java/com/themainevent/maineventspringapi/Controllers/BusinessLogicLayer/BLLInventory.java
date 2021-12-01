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

    //Find By Inventory
    public List<ModelInventory> getByIngredient(ModelInventory ingredients){
        return inventoryRepo.findByIngredient(ingredients);
    }

    //Delete
    public String Delete(ModelInventory ingredients){
        try {
            inventoryRepo.deleteByIngredient(ingredients);
            return "Inventory item has been deleted";
        }catch (Exception e){
            e.printStackTrace();
            return "Inventory Item could not be Deleted";
        }
    }

    //Update
    public String updateInventory(ModelInventory oldIngredient, ModelInventory newIngredient){
        try {
            ModelInventory inventory = inventoryRepo.findFirstByIngredient(oldIngredient);
            inventory.setIngredient(newIngredient.getIngredient());
            inventory.setCostPerServing(newIngredient.getCostPerServing());
            inventory.setMinQty(newIngredient.getMinQty());
            inventory.setQty(newIngredient.getQty());
            inventoryRepo.save(inventory);

            return "Inventory has been Updated";
        }catch (Exception e){
            e.printStackTrace();
            return "Inventory could not be Updated";
        }
    }
}
