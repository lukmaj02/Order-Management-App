package com.App.orderservice.util;

import com.App.orderservice.Model.Order;
import com.App.orderservice.dtos.OrderExchange;


public class OrderMapper {
    private OrderMapper() {}

    public static OrderExchange mapToOrderExchange(Order order){
        return OrderExchange.builder()
                .products(ProductMapper.map(order.getOrderProducts()))
                .clientId(order.getClientId())
                .build();
    }
}
