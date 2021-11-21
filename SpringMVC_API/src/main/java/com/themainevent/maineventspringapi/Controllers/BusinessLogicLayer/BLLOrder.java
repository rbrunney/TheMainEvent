package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelOrder;
import com.themainevent.maineventspringapi.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BLLOrder {
    @Autowired
    private OrderRepository orderRepo;

    public String add(ModelOrder order) {
        try {
            orderRepo.save(order);
            return "Order has been saved";
        } catch(Exception e) {
            e.printStackTrace();
            return "Order could not be saved";
        }
    }

//    public List<ModelOrder> findById(int id){
//        return orderRepo.findFirstByOrderId(id);
//    }


}
