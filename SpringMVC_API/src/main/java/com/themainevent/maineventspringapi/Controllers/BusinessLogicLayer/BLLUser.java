
package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelUser;
import com.themainevent.maineventspringapi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BLLUser {

    @Autowired
    private UserRepository userRepo;

    public String addUser(ModelUser user) {
        try {
            if(userRepo.findByUsername(user.getUsername()).getUsername().equals(user.getUsername())) {
                throw new Exception();
            }
        } catch(NullPointerException npe) {
            userRepo.save(user);
            return "User has been added";
        } catch(Exception e) {
            return "User could not be saved";
        }

        return "User could not be saved";
    }

    public String checkUsers(String username) {
        try {
            return userRepo.findByUsername(username).getPassword();
        } catch(Exception e) {
            e.printStackTrace();
            return "Failed";
        }
    }

    //Find by ID
    public String getEmailById(String _id){
        try {
            return userRepo.findBy_id(_id).getEmail();
        }catch (Exception e) {
            e.printStackTrace();
            return "Failed to find by ID";
        }
    }

}
