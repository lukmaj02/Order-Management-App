package com.app.pickupservice.Service;

import com.app.pickupservice.Model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();
    Order getOrderById(String id);


}
