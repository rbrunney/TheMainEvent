package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelIngredient;
import com.themainevent.maineventspringapi.Models.ModelMenuItem;
import com.themainevent.maineventspringapi.Repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BLLMenuItem {

    @Autowired
    private MenuItemRepository menuItemRepo;

    public String addMenuItem(ModelMenuItem menuItem){

        try{
            menuItemRepo.save(menuItem);
            return "Added to Menu Items.";
        }catch(Exception e){
            e.printStackTrace();
            return "Could not be added to Menu Items.";
        }
    }

    //Find By Name
    public List<ModelMenuItem> getByFirstName(String name){
        return menuItemRepo.findByName(name);
    }

    //Delete
    public String Delete(String name){
        try {
            menuItemRepo.deleteByName(name);
            return "Menu Item has been deleted";
        }catch (Exception e){
            e.printStackTrace();
            return "Menu Item could not be Deleted";
        }
    }

    //Update
    public String updateMenuItem(String name, String newName){
        try {
            List<ModelMenuItem> menuItem = menuItemRepo.findByName(name);


            return "Menu Item has been Updated";
        }catch (Exception e){
            e.printStackTrace();
            return "Menu Item could not be Updated";
        }
    }
}
