package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.SendEmail.SendMail;
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

    //Find all

    public List<ModelOrderDetails> findAllOrders(){
        try {
            return orderDetailRepo.findAll();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //Find by _id
    public ModelOrderDetails findById(String id) {
        try {
            return orderDetailRepo.findBy_id(id);
        } catch(Exception e) {
            e.printStackTrace();
            return new ModelOrderDetails();
        }
    }

    public String updateOrderDetails(ModelOrderDetails orderDetails) {
        try {
            orderDetailRepo.save(orderDetails);
            return "OrderDetail Updated";
        } catch(Exception e) {
            e.printStackTrace();
            return "Could not be updated!";
        }
    }

    public String deleteOrderDetails(ModelOrderDetails orderDetails) {
        try {
            orderDetailRepo.delete(orderDetails);
            return "Order has been deleted";
        } catch(Exception e) {
            e.printStackTrace();
            return "Order Details Could not be Deleted";
        }
    }
}
