package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelInventory;
import com.themainevent.maineventspringapi.Models.ModelMenuItem;
import com.themainevent.maineventspringapi.Repositories.InventoryRepository;
import com.themainevent.maineventspringapi.Repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
