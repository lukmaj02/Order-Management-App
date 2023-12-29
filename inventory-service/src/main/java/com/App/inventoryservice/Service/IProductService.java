package com.App.inventoryservice.Service;

import com.App.inventoryservice.Model.OrderExchange;
import com.App.inventoryservice.Model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(String id);
    void addProduct(Product product);
    void processOrder(OrderExchange orderExchange);
}
