package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLUser;
import com.themainevent.maineventspringapi.Models.ModelUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private BLLUser bllUser;

    @GetMapping(path="/check")
    public String check() {
        return "Hello from the user";
    }

    @PostMapping(path="/add")
    public String add(@RequestBody ModelUser user) {
        //Testing/validating Values
        System.out.println("[USER INFO] fname: " + user.getFname());
        System.out.println("[USER INFO] lname: " + user.getLname());
        System.out.println("[USER INFO] phone: " + user.getPhone());
        System.out.println("[USER INFO] email: " + user.getEmail());
        System.out.println("[USER INFO] customerID: " + user.getCustomerID());
        System.out.println("[USER INFO] user: " + user.getUsername());
        System.out.println("[USER INFO] password: " + user.getPassword());
        return bllUser.addUser(user);
    }
}
