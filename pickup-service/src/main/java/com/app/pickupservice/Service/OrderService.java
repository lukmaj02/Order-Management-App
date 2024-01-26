package com.app.pickupservice.Service;

import com.app.pickupservice.Exceptions.OrderNotFoundException;
import com.app.pickupservice.Model.Order;
import com.app.pickupservice.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }
}
