
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

    public ModelUser checkUsers(String username) {
        try {
            return userRepo.findByUsername(username);
        } catch(Exception e) {
            e.printStackTrace();
            return new ModelUser();
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

    public ModelUser getUser(String _id){
        return userRepo.findBy_id(_id);
    }

    public ModelUser editUser(String id, ModelUser user){
        try {
            System.out.println(id);
            System.out.println(userRepo.findBy_id(id).getEmail());
            ModelUser temp = userRepo.findBy_id(id);
            temp.setEmail(user.getEmail());
            temp.setUsername(user.getUsername());
            temp.setPhone(user.getPhone());
            temp.setPassword(user.getPassword());
            return userRepo.save(temp);
        } catch(Exception e) {
            e.printStackTrace();
            return new ModelUser();
        }

    }

}
