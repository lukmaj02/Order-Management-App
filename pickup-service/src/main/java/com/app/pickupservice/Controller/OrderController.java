package com.app.pickupservice.Controller;

import com.app.pickupservice.Model.Order;
import com.app.pickupservice.Service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/pickup")
public class OrderController {

    private final IOrderService orderService;
    @GetMapping("")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/")
    public Order getOrderById(@RequestParam String id){
        return orderService.getOrderById(id);
    }
}
