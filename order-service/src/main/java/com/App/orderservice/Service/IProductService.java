package com.App.orderservice.Service;

import com.App.orderservice.Model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getOrderProducts(String orderId);
    Product getOrderProduct(String orderProductId);
    void addProductToOrder(Product product, String orderId);
    void deleteProductFromOrder(String productOrderId);
    void updateProductToOrder(String productOrderId, Integer quantity);
}
