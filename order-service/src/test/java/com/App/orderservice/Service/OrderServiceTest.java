package com.App.orderservice.Service;

import com.App.orderservice.Client.InventoryClient;
import com.App.orderservice.Client.NotificationClient;
import com.App.orderservice.Exceptions.OrderNotFoundException;
import com.App.orderservice.Model.Order;
import com.App.orderservice.Model.Product;
import com.App.orderservice.Repository.OrderRepository;
import com.App.orderservice.dtos.Email;
import com.App.orderservice.dtos.ProductExchange;
import org.apache.commons.math.linear.ArrayRealVector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {
    private OrderRepository orderRepository;
    private NotificationClient notificationClient;
    private InventoryClient inventoryClient;
    private static OrderService orderServiceMock;
    private static Order order1;
    private static Order order2;
    private static ProductExchange product1;
    private static ProductExchange product2;
    private static Email email;

    @BeforeAll
    public static void setup(){
        order1 = Order.builder()
                .orderId("123")
                .orderDate(LocalDateTime.of(LocalDate.of(2002,10,10), LocalTime.of(10,10)))
                .clientId("1234")
                .build();

        order2 = Order.builder()
                .orderId("987")
                .orderDate(LocalDateTime.of(LocalDate.of(2023,12,12), LocalTime.of(12,12)))
                .clientId("4321")
                .build();
        product1 = ProductExchange.builder()
                .productName("iphone")
                .quantity(2)
                .productId("abc")
                .build();

        product2 = ProductExchange.builder()
                .productName("iphone 15")
                .quantity(1)
                .productId("abcd")
                .build();


        email = Email.builder()
                .toEmail("test@test.com")
                .title("order placed successfully")
                .message("hurray")
                .build();
    }

    @BeforeEach
    public void setupBeforeEach(){
        orderRepository = mock(OrderRepository.class);
        notificationClient = mock(NotificationClient.class);
        inventoryClient = mock(InventoryClient.class);

        orderServiceMock = new OrderService(orderRepository,inventoryClient, notificationClient);
    }


    @Test
    void getAllOrders() {
        when(orderRepository.findAll()).thenReturn(Arrays.asList(order1,order2));

        List<Order> actualOrders = orderServiceMock.getAllOrders();
        verify(orderRepository).findAll();

        assertEquals(Arrays.asList(order1,order2), actualOrders);
    }

    @Test
    void getOrderByIdFailed() {
        when(orderRepository.findById("test")).thenThrow(new OrderNotFoundException("test"));
        assertThrows(OrderNotFoundException.class, () -> orderServiceMock.getOrderById("test"));
        verify(orderRepository).findById("test");
    }

    @Test
    void getOrderByIdSuccessfully() {
        when(orderRepository.findById("123")).thenReturn(Optional.ofNullable(order1));
        Order returnedOrder = orderServiceMock.getOrderById("123");
        verify(orderRepository).findById("123");

        assertEquals(returnedOrder, order1);
    }

    @Test
    void placeOrderSuccessfully() {
        List<ProductExchange> products = Arrays.asList(product1,product2);
        when(inventoryClient.processProduct(products)).thenReturn(ResponseEntity.ok().build());
        when(notificationClient.sendMail(email)).thenReturn(ResponseEntity.ok().build());

        ResponseEntity<Void> responseFromInventoryClient = inventoryClient.processProduct(products);
        verify(inventoryClient).processProduct(products);

        ResponseEntity<Void> responseFromNotificationClient = notificationClient.sendMail(email);
        verify(notificationClient).sendMail(email);

        assertEquals(responseFromInventoryClient.getStatusCode(), HttpStatusCode.valueOf(200));
        assertEquals(responseFromNotificationClient.getStatusCode(), HttpStatusCode.valueOf(200));

    }

    @Test
    void placeOrderUnsuccessfullyDueToInventoryService(){
        List<ProductExchange> products = Arrays.asList(product1, product2);
        when(inventoryClient.processProduct(products)).thenReturn(ResponseEntity.status(HttpStatusCode.valueOf(409)).build());

        ResponseEntity<Void> responseFromInventoryClient = inventoryClient.processProduct(products);
        verify(inventoryClient).processProduct(products);

        assertEquals(responseFromInventoryClient.getStatusCode(), HttpStatusCode.valueOf(409));
    }
}