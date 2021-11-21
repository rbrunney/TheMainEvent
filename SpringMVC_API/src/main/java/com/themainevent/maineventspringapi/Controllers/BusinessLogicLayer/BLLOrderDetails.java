package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelOrderDetails;
import com.themainevent.maineventspringapi.Repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
