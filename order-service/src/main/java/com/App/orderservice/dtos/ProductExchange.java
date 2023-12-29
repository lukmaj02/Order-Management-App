package com.App.orderservice.dtos;

import lombok.Builder;

@Builder
public record ProductExchange(String productId, String productName, Integer quantity) {
}