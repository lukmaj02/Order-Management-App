package com.App.orderservice.Controller;

import com.App.orderservice.Model.Order;
import com.App.orderservice.Service.IOrderService;
import com.App.orderservice.dtos.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final IOrderService orderService;
    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderById(@PathVariable String orderId){
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDto order){
        orderService.createOrder(order);
    }

    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@RequestParam String id){
        orderService.deleteOrder(id);
    }

    @PostMapping("/place")
    @ResponseStatus(HttpStatus.OK)
    public void placeOrder(@RequestParam String id){
        orderService.placeOrder(id);
    }
}
