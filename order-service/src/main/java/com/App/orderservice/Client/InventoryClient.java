package com.App.orderservice.Client;

import com.App.orderservice.dtos.OrderExchange;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface InventoryClient {

    @PostExchange("/api/v1/inventory-service/order")
    void placeOrder(@RequestBody OrderExchange order);


}
