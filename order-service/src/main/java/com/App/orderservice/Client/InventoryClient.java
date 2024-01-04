package com.App.orderservice.Client;

import com.App.orderservice.dtos.ProductExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange
public interface InventoryClient {
    @PostExchange("/api/v1/product/order")
    ResponseEntity<Void> processProduct(@RequestBody List<ProductExchange> products);

    @PostExchange("/api/v1/product/availability")
    boolean checkProductAvailability(@RequestBody ProductExchange productExchange);
}
