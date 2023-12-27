package com.App.orderservice.Service;

import com.App.orderservice.Model.Order;
import com.App.orderservice.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElseThrow();
    }

    @Override
    public void addOrder(Order order) {
        order.setId(UUID.randomUUID().toString());
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
    }


}