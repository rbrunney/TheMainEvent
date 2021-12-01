package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLOrderDetails;
import com.themainevent.maineventspringapi.Models.ModelInventory;
import com.themainevent.maineventspringapi.Models.ModelOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path="/orderDetails")
public class OrderDetailsController {

    @Autowired
    private BLLOrderDetails bllOrderDetails;

    @GetMapping(path="/check")
    public String check() {
        return "Hello from Order Details";
    }

    @PostMapping(path="/add/{userEmail}")
    public String add(@RequestBody ModelOrderDetails orderDetails, @PathVariable String userEmail) {
        //Testing/Validating values
        System.out.println("[ORDER DETAILS INFO] Date: " + orderDetails.getDateOfEvent());
        System.out.println("[ORDER DETAILS INFO] Location: " + orderDetails.getLocationOfEvent());
        System.out.println("[ORDER DETAILS INFO] Num of Guests: " + orderDetails.getNumberOfGuests());
        System.out.println("[ORDER DETAILS INFO] Total Cost: " + orderDetails.getTotalCostOfEvent());
        System.out.println("[ORDER DETAILS INFO] Menu Items: " + orderDetails.getMenuItems());

        return bllOrderDetails.add(orderDetails, userEmail);
    }

    @GetMapping(path = "/findAll")
    public List<ModelOrderDetails> findAll(){
        return bllOrderDetails.findAllOrders();
    }

//    @DeleteMapping(path = "/delete/{name}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public String delete(@PathVariable String name){return bllOrderDetails.Delete(name);}
//
//    @PutMapping(path = "/update/{oldName}/{newName}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public String update(@PathVariable String newName, @PathVariable String oldName){
//        return bllOrderDetails.updateOrderDetails(oldName, newName);
//    }
//
//    @GetMapping(path = "/search/{name}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public List<ModelOrderDetails> read(@PathVariable String name) {
//        return bllOrderDetails.getByFirstName(name);
//    }
}
