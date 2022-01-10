package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLOrderDetails;
import com.themainevent.maineventspringapi.Models.ModelInventory;
import com.themainevent.maineventspringapi.Models.ModelOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path="/orderDetails")
@CrossOrigin(origins = "http://localhost:3000")
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
        System.out.println("[ORDER DETAILS INFO] Location: " + orderDetails.getLocationOfEvent());
        System.out.println("[ORDER DETAILS INFO] Num of Guests: " + orderDetails.getNumberOfGuests());
        System.out.println("[ORDER DETAILS INFO] Total Cost: " + orderDetails.getTotalCostOfEvent());
        System.out.println("[ORDER DETAILS INFO] Menu Items: " + orderDetails.getMenuItems());

        return bllOrderDetails.add(orderDetails);
    }

    @GetMapping(path = "/findAll")
    public List<ModelOrderDetails> findAll(){
        return bllOrderDetails.findAllOrders();
    }

    @GetMapping(path = "/getOrderDetailById/{id}")
    public ModelOrderDetails findOrderById(@PathVariable String id){
        return bllOrderDetails.findById(id);
    }

    @PutMapping(path="/updateOrderDetails")
    public String updateOrderDetails(@RequestBody ModelOrderDetails orderDetails) {
        return bllOrderDetails.updateOrderDetails(orderDetails);
    }

    @DeleteMapping(path="/deleteOrderDetails")
    public String deleteOrderDetails(@RequestBody ModelOrderDetails orderDetails) {
        return bllOrderDetails.deleteOrderDetails(orderDetails);
    }
}
