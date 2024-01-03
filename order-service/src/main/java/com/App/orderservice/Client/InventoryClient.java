package com.App.orderservice.Client;

import com.App.orderservice.Model.Product;
import com.App.orderservice.dtos.OrderExchange;
import com.App.orderservice.dtos.ProductExchange;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange
public interface InventoryClient {
    @PostExchange("/api/v1/order")
    void processProduct(@RequestBody List<ProductExchange> products);

    @PostExchange("/api/v1/product-availability")
    boolean checkProductAvailability(@RequestBody ProductExchange productExchange);
}
