package com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.SendEmail.SendMail;
import com.themainevent.maineventspringapi.Models.ModelMenuItem;
import com.themainevent.maineventspringapi.Models.ModelOrderDetails;
import org.springframework.stereotype.Service;

@Service
public class BLLSendEmail {

    public String orderPendingEmail(ModelOrderDetails order, String userEmail) {
        try {

            StringBuilder emailBody = new StringBuilder("<h1 style='text-align: center;'> The Main Event </header>\n" +
            "    <h2 style='text-align: center; text-decoration: underline;'> Order Pending </h1>\n" +
            "    <h3 style='text-align: center; text-decoration: underline;'> Type of Event </h3>\n" +
            "    <h5 style='text-align: center;'> " + order.getTypeOfEvent() + " </h5>\n" +
            "    <h3 style='text-align: center; text-decoration: underline;'> Date </h3>\n" +
            "    <h5 style='text-align: center;'> " + order.getDateOfEvent() + " </h5>\n" +
            "    <h3 style='text-align: center; text-decoration: underline;'> Location </h3>\n" +
            "    <h5 style='text-align: center;'> " + order.getLocationOfEvent() + " </h5>\n" +
            "    <h3 style='text-align: center; text-decoration: underline;'> Number of Guests </h3>\n" +
            "    <h5 style='text-align: center;'> Number of Guests: " + order.getNumberOfGuests() + " </h5>\n" +
            "    <h3 style='text-align: center; text-decoration: underline;'> Total Cost </h3>\n" +
            "    <h5 style='text-align: center;'> $ " + order.getTotalCostOfEvent() + " </h5>\n" +
            "    <h3 style='text-align: center; text-decoration: underline;'> Menu Items </h3>\n");

            try {
//                for(String menuItem : order.getMenuItems()) {
//                    emailBody.append("<h5 style='text-align: center;'> ").append(menuItem.toString()).append(" </h5>\n");
//                }
            } catch(Exception e) {
                emailBody.append("<h5 style='text-align: center;'> No Menu Items for Order </h5>");
            }


            new SendMail(userEmail, "Order Pending", emailBody.toString());
            return "Email Sent Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Email Sent Failed";
        }
    }

    public String orderConfirmationEmail(ModelOrderDetails order, String userEmail) {
        try {

            String emailBody = "<h1 style='text-align: center;'> The Main Event </h1>\n" +
                    "    <h3 style=\"text-align: center; text-decoration: underline;\"> Order Cofirmation </h3>\n" +
                    "    <h5 style=\"text-align: center;\"> Your order for " + order.getDateOfEvent() + " has been confirmed. </h5>\n" +
                    "\n" +
                    "\n" +
                    "    <h3 style=\"text-align: center; text-decoration: underline;\"> Thank you! </h3>\n" +
                    "    <h5 style=\"text-align: center;\"> We are THE MAIN EVENT let us take care of yours! </h5>";

            new SendMail(userEmail, "Order Confirmation", emailBody);

            return "Email Sent Successfully";
        } catch(Exception e) {
            return "Email Sent Failed";
        }
    }


    public String orderDeniedEmail(String userEmail) {
        try {
            String emailBody = "<h1 style='text-align: center;'> The Main Event </h1>\n" +
                    "    <h3 style=\"text-align: center; text-decoration: underline;\"> Order Denied </h3>\n" +
                    "\n" +
                    "    <h5 style=\"text-align: center;\"> We are sorry to inform you, but we have to deny your order request. </h5>\n" +
                    "    <h5 style=\"text-align: center;\"> We hope you will consider us in the future! We hope to see you next time! </h5>";

            new SendMail(userEmail, "Order Denied", emailBody);
            return "Email Sent Successfully";
        } catch(Exception e) {
            return "Email Sent Failed";
        }
    }

    public String emailConfirmation(String userEmail) {
        try {
            String emailBody = "<h1 style='text-align: center;'> The Main Event </h1>\n" +
                    "    <h3 style=\"text-align: center; text-decoration: underline;\"> Welcome to The Main Event </h3>\n" +
                    "    <h5 style=\"text-align: center;\"> We are THE MAIN EVENT let us take care of yours! </h5>\n" +
                    "    <h5 style=\"text-align: center;\"> Thank you for choosing to be apart of THE MAIN EVENT let us be at your service</h5>";
            new SendMail(userEmail, "Welcome to The Main Event", emailBody);
            return "Email Sent Successfully";
        } catch(Exception e) {
            return "Email Sent Failed";
        }
    }
}
