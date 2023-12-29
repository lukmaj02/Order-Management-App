package com.App.orderservice.dtos;

import lombok.Builder;

import java.util.List;

@Builder
public record OrderExchange(String clientId, List<ProductExchange> products) {
}
