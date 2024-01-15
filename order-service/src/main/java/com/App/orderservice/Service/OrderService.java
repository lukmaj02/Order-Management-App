package com.App.orderservice.Service;

import com.App.orderservice.Client.InventoryClient;
import com.App.orderservice.Client.NotificationClient;
import com.App.orderservice.Exceptions.OrderNotFoundException;
import com.App.orderservice.Model.Order;
import com.App.orderservice.Repository.OrderRepository;
import com.App.orderservice.dtos.Email;
import com.App.orderservice.dtos.OrderDto;
import com.App.orderservice.util.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final NotificationClient notificationClient;
    private static final String ORDER_PLACED_SUCCESSFULLY = "Order was placed successfully!";
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @Override
    public void createOrder(OrderDto orderDto) {
        var order = Order.builder()
                .clientId(orderDto.clientId())
                .orderId(UUID.randomUUID().toString())
                .orderDate(LocalDateTime.now())
                .build();
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    @Transactional
    public void placeOrder(String orderId) {
        var order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
        var response = inventoryClient.processProduct(ProductMapper.map(order.getOrderProducts()));
        if(response.getStatusCode().is2xxSuccessful()){
            orderRepository.delete(order);
            notificationClient.sendMail(Email.builder()
                    .toEmail("wasidek826@tanlanav.com")   //todo
                    .message("")
                    .title(ORDER_PLACED_SUCCESSFULLY)
                    .build());
        }
    }
}
