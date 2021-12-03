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

    public String add(ModelOrderDetails orderDetails/*, String userEmail*/) {
        try {
            orderDetailRepo.save(orderDetails);

//            StringBuilder emailBody = new StringBuilder("<h1 style='text-align: center;'> The Main Event </header>\n" +
//                    "    <h2 style='text-align: center; text-decoration: underline;'> Order Confirmation </h1>\n" +
//                    "    <h3 style='text-align: center; text-decoration: underline;'> Type of Event </h3>\n" +
//                    "    <h5 style='text-align: center;'> " + orderDetails.getTypeOfEvent() + " </h5>\n" +
//                    "    <h3 style='text-align: center; text-decoration: underline;'> Date </h3>\n" +
//                    "    <h5 style='text-align: center;'> " + orderDetails.getDateOfEvent() + " </h5>\n" +
//                    "    <h3 style='text-align: center; text-decoration: underline;'> Location </h3>\n" +
//                    "    <h5 style='text-align: center;'> " + orderDetails.getLocationOfEvent() + " </h5>\n" +
//                    "    <h3 style='text-align: center; text-decoration: underline;'> Number of Guests </h3>\n" +
//                    "    <h5 style='text-align: center;'> Number of Guests: " + orderDetails.getNumberOfGuests() + " </h5>\n" +
//                    "    <h3 style='text-align: center; text-decoration: underline;'> Total Cost </h3>\n" +
//                    "    <h5 style='text-align: center;'> $ " + orderDetails.getTotalCostOfEvent() + " </h5>\n" +
//                    "    <h3 style='text-align: center; text-decoration: underline;'> Menu Items </h3>\n");
//
//            for(ModelMenuItem menuItem : orderDetails.getMenuItems()) {
//                emailBody.append("<h5 style='text-align: center;'> ").append(menuItem.toString()).append(" </h5>\n");
//            }
//
//            new SendMail(userEmail, "Order Confirmation", emailBody.toString());
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
