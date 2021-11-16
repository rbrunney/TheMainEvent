package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLOrder;
import com.themainevent.maineventspringapi.Models.ModelOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
//    BLLOrder bllOrder = new BLLOrder();
//
//    @PostMapping(path = "/create")
//    public String createOrder(HttpServletResponse response){
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Headers",
//                "Origin, X-Requested-With, Content-type: application/json, Accept:*");
//
//        ModelOrder newOrder = new ModelOrder();
//        // ----------------------------------------------------
//        return bllOrder.addOrder(newOrder);
//    }
//    @GetMapping(path = "/get")
//    public ModelOrder getOrder(HttpServletRequest request){
//        return  bllOrder.getOrder(request.querySelector("id"));
//    }
//
//    @GetMapping(path = "/getOrders")
//    public ModelOrder[] getOrders() {
//        return bllOrder.getAllOrders();
//    }
//
//    @GetMapping(path = "/getCompleteOrders")
//    public ModelOrder[] getCompleteOrders(){
//        return bllOrder.getCompleteOrders();
//    }
//
//    @GetMapping(path = "/getCurrentOrders")
//    public ModelOrder[] getCurrentOrders(){
//        return bllOrder.getAllCurrentOrders();
//    }
}
