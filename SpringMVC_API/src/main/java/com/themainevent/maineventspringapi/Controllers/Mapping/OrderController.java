package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLOrder;
import com.themainevent.maineventspringapi.Models.ModelInventory;
import com.themainevent.maineventspringapi.Models.ModelOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path = "/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    private BLLOrder bllOrder;

    @GetMapping(path="/check")
    public String check() {
        return "Hello from Order";
    }

    @PostMapping(path="/add")
    public String add(@RequestBody ModelOrder order) {
        //testing/Validation Values
        System.out.println("[ORDER INFO] CustomerID: " + order.getCustomerId());
        System.out.println("[ORDER INFO] OrderID: " + order.getOrderId());
        System.out.println("[ORDER INFO] Cost: " + order.getCost());
        System.out.println("[ORDER INFO] Confirmed: " + order.isConfirmed());
        System.out.println("[ORDER INFO] Paid Deposit: " + order.isPaidDeposit());
        System.out.println("[ORDER INFO] Completed Job: " + order.isCompletedJob());
        System.out.println("[ORDER INFO] Paid In Full: " + order.isPaidInFull());

        return bllOrder.add(order);
    }

//    @DeleteMapping(path = "/delete/{name}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public String delete(@PathVariable String name){return bllOrder.Delete(name);}
//
//    @PutMapping(path = "/update/{oldName}/{newName}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public String update(@PathVariable String newName, @PathVariable String oldName){
//        return bllOrder.updateOrder(oldName, newName);
//    }
//
//    @GetMapping(path = "/search/{name}")
//    @ResponseStatus(code = HttpStatus.OK)
//    public List<ModelOrder> read(@PathVariable String name) {
//        return bllOrder.getByFirstName(name);
//    }
}
