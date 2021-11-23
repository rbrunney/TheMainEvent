package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelMenuItem;
import com.themainevent.maineventspringapi.Models.ModelOrderDetails;
import com.themainevent.maineventspringapi.Repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BLLOrderDetails {

    @Autowired
    private OrderDetailsRepository orderDetailRepo;

    public String add(ModelOrderDetails orderDetails) {
        try {
            orderDetailRepo.save(orderDetails);
            return "Order Details has been saved";
        } catch(Exception e) {
            e.printStackTrace();
            return "Order Details could not be saved";
        }
    }

//    //Find By Name
//    public List<ModelOrderDetails> getByFirstName(String name){
//        return orderDetailRepo.findByName(name);
//    }
//
//    //Delete
//    public String Delete(String name){
//        try {
//            orderDetailRepo.deleteByName(name);
//            return "Order Details has been deleted";
//        }catch (Exception e){
//            e.printStackTrace();
//            return "Order Details could not be Deleted";
//        }
//    }
//
//    //Update
//    public String updateOrderDetails(String name, String newName){
//        try {
//            List<ModelOrderDetails> orderDetails = orderDetailRepo.findByName(name);
//
//
//            return "Order Details has been Updated";
//        }catch (Exception e){
//            e.printStackTrace();
//            return "Order Details could not be Updated";
//        }
//    }
}
