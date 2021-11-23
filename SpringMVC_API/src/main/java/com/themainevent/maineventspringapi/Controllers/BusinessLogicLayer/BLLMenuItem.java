package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

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
        return menuItemRepo.findByNameOfDish(name);
    }

    //Delete
    public String Delete(String name){
        try {
            menuItemRepo.deleteByNameOfDish(name);
            return "Menu Item has been deleted";
        }catch (Exception e){
            e.printStackTrace();
            return "Menu Item could not be Deleted";
        }
    }

    //Update
    public String updateMenuItem(String oldMenuItem, ModelMenuItem newMenuItem){
        try {
            ModelMenuItem menuItem = menuItemRepo.findFirstByNameOfDish(oldMenuItem);
            menuItem.setIngredients(newMenuItem.getIngredients());
            menuItem.setNameOfDish(newMenuItem.getNameOfDish());
            menuItem.setPrice(newMenuItem.getPrice());
            menuItem.setIngredientsCost(newMenuItem.getIngredientsCost());
            menuItemRepo.save(menuItem);
            return "Menu Item has been Updated";
        }catch (Exception e){
            e.printStackTrace();
            return "Menu Item could not be Updated";
        }
    }
}
