package com.App.orderservice.util;

import com.App.orderservice.Model.Product;
import com.App.orderservice.dtos.ProductExchange;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    private ProductMapper(){}
    public static List<ProductExchange> map(List<Product> products){
        return products.stream()
                .map(product -> ProductExchange.builder()
                        .productId(product.getProductId())
                        .productName(product.getProductName())
                        .quantity(product.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }
}
