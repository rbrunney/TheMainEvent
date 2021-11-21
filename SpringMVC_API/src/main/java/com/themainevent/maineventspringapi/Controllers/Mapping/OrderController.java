package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLOrder;
import com.themainevent.maineventspringapi.Models.ModelOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/order")
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
}
