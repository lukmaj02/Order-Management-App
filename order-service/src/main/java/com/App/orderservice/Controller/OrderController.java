package com.App.orderservice.Controller;

import com.App.orderservice.Model.Order;
import com.App.orderservice.Service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-service")
public class OrderController {

    private final IOrderService orderService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String test(){
        return "UDALO SIE";
    }
    @GetMapping("/order")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderById(@RequestParam String id){
        return orderService.getOrderById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }
}
