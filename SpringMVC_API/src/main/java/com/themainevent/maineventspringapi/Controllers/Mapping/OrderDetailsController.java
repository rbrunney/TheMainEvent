package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLOrderDetails;
import com.themainevent.maineventspringapi.Models.ModelOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/orderDetails")
public class OrderDetailsController {

    @Autowired
    private BLLOrderDetails bllOrderDetails;

    @GetMapping(path="/check")
    public String check() {
        return "Hello from Order Details";
    }

    @PostMapping(path="/add")
    public String add(@RequestBody ModelOrderDetails orderDetails) {
        //Testing/Validating values
        System.out.println("[ORDER DETAILS INFO] Date: " + orderDetails.getDateOfEvent());
        System.out.println("[ORDER DETAILS INFO] Time: " + orderDetails.getTimeOfEvent());
        System.out.println("[ORDER DETAILS INFO] Location: " + orderDetails.getLocationOfEvent());
        System.out.println("[ORDER DETAILS INFO] Num of Guests: " + orderDetails.getNumberOfGuests());
        System.out.println("[ORDER DETAILS INFO] Total Cost: " + orderDetails.getTotalCostOfEvent());
        System.out.println("[ORDER DETAILS INFO] Menu Items: " + orderDetails.getMenuItems());

        return bllOrderDetails.add(orderDetails);
    }
}
