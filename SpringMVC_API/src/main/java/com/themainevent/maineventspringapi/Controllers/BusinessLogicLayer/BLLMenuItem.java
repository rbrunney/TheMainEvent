package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelMenuItem;
import com.themainevent.maineventspringapi.Repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
