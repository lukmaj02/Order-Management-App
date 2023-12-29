package com.App.orderservice.Service;

import com.App.orderservice.Model.Order;
import com.App.orderservice.dtos.OrderDto;


import java.util.List;

public interface IOrderService {

    List<Order> getAllOrders();
    Order getOrderById(String orderId);
    void createOrder(OrderDto order);
    void deleteOrder(String orderId);
    void placeOrder(String orderId);
}
