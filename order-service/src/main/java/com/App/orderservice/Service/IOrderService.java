package com.App.orderservice.Service;

import com.App.orderservice.Model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();

    Order getOrderById(String id);

    void addOrder(Order order);
}
