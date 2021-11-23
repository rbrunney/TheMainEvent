package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelMenuItem;
import com.themainevent.maineventspringapi.Models.ModelUser;
import com.themainevent.maineventspringapi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BLLUser {

    @Autowired
    private UserRepository userRepo;

    public String addUser(ModelUser user) {
        try {
            userRepo.save(user);
            return "User has been added";
        } catch(Exception e) {
            e.printStackTrace();
            return "User could not be saved";
        }
    }

    //Find By Name
    public List<ModelUser> getByFirstName(String name){
        return userRepo.findByName(name);
    }

    //Delete
    public String Delete(String name){
        try {
            userRepo.deleteByName(name);
            return "User has been deleted";
        }catch (Exception e){
            e.printStackTrace();
            return "User could not be Deleted";
        }
    }

    //Update
    public String updateUser(String name, String newName){
        try {
            List<ModelUser> user = userRepo.findByName(name);

            return "User has been Updated";
        }catch (Exception e){
            e.printStackTrace();
            return "User could not be Updated";
        }
    }
}