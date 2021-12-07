package com.themainevent.maineventspringapi.Controllers.Mapping;

import com.themainevent.maineventspringapi.Controllers.BusinessLogicLayer.BLLSendEmail;
import com.themainevent.maineventspringapi.Models.ModelOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(path="/email")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {
    @Autowired
    private BLLSendEmail bllEmail;

    @PostMapping(path="/sendOrderPending/{userEmail}")
    public String sendPendingOrderEmail(@RequestBody ModelOrderDetails order, @PathVariable String userEmail) {
        return bllEmail.orderPendingEmail(order, userEmail);
    }

    @PostMapping(path="/sendOrderConfirmation/{userEmail}")
    public String sendOrderConfirmation(HttpServletResponse response, @RequestBody ModelOrderDetails order, @PathVariable String userEmail) {
        return bllEmail.orderConfirmationEmail(order, userEmail);
    }

    @GetMapping(path="/sendOrderDenied/{userEmail}")
    public String sendOrderDenied(@PathVariable String userEmail) {
        return bllEmail.orderDeniedEmail(userEmail);
    }

    @GetMapping(path="/sendEmailConfirmation/{userEmail}")
    public String sendEmailConfirmation(@PathVariable String userEmail) {
        return bllEmail.emailConfirmation(userEmail);
    }
}
