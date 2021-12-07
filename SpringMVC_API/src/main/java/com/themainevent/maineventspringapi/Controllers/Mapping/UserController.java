package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLUser;
import com.themainevent.maineventspringapi.Models.ModelUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
        System.out.println("[USER INFO] customerID: " + user.get_id());
        System.out.println("[USER INFO] user: " + user.getUsername());
        System.out.println("[USER INFO] password: " + user.getPassword());
        return bllUser.addUser(user);
    }

    @GetMapping(path="/checkUser/{username}")
    public String checkUsers(@PathVariable String username) {
        return bllUser.checkUsers(username);
    }

    @GetMapping(path = "/getUserEmail/{id}")
    public String getEmail(HttpServletResponse response, @PathVariable String id){
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Context-Type, Accept*");
        return bllUser.getEmailById(id);
    }

//    @DeleteMapping(path = "/delete/{name}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public String delete(@PathVariable String name){return bllUser.Delete(name);}
//
//    @PutMapping(path = "/update/{oldName}/{newName}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public String update(@PathVariable String newName, @PathVariable String oldName){
//        return bllUser.updateUser(oldName, newName);
//    }
//
//    @GetMapping(path = "/search/{name}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public List<ModelUser> read(@PathVariable String name) {
//        return bllUser.getByFirstName(name);
//    }
}
