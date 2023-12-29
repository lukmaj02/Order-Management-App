package com.App.inventoryservice.Model;

import java.util.List;

public record OrderExchange(String clientId, List<Product> products) {
}
