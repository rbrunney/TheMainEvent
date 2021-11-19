package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelOrder;
import com.themainevent.maineventspringapi.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BLLOrder {
    @Autowired
    private OrderRepository orderRepo;

    public List<ModelOrder> findById(int id){
        return orderRepo.findFirstByOrderId(id);
    }


}
