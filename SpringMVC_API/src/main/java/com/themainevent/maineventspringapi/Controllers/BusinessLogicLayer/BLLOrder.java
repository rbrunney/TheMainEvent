package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Models.ModelMenuItem;
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

    //Find By Name
    public List<ModelOrder> getByFirstName(String name){
        return orderRepo.findByName(name);
    }

    //Delete
    public String Delete(String name){
        try {
            orderRepo.deleteByName(name);
            return "Order has been deleted";
        }catch (Exception e){
            e.printStackTrace();
            return "Order could not be Deleted";
        }
    }

    //Update
    public String updateOrder(String name, String newName){
        try {
            List<ModelOrder> order = orderRepo.findByName(name);


            return "Order has been Updated";
        }catch (Exception e){
            e.printStackTrace();
            return "Order could not be Updated";
        }
    }

//    public List<ModelOrder> findById(int id){
//        return orderRepo.findFirstByOrderId(id);
//    }


}
