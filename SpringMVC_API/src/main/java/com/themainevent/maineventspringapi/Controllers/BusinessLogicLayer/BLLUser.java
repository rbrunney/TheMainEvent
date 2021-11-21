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
            userRepo.save(user);
            return "User has been added";
        } catch(Exception e) {
            e.printStackTrace();
            return "User could not be saved";
        }
    }
}
