package com.app.pickupservice.Controller;

import com.app.pickupservice.Model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class OrderController {

    @GetMapping("")
    public Order getAllOrders(){
        return null;//todo
    }

}
