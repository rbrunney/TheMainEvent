package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Controllers.DataAccessLayer.DALOrder;
import com.themainevent.maineventspringapi.Models.ModelOrder;

public class BLLOrder {
    DALOrder dal = new DALOrder();

    public String addOrder(ModelOrder order) {
        dal.addOrder(order);
        return "Order Added!";
    }

    public ModelOrder getOrder(String id){
        return dal.getOrder(id);
    }

    public ModelOrder[] getAllOrders() {
        return dal.getAllOrders();
    }

    public ModelOrder[] getCompleteOrders(){
        return dal.getAllCompleteOrders();
    }

    public ModelOrder[] getAllCurrentOrders(){
        return dal.getAllCurrentOrders();
    }
}