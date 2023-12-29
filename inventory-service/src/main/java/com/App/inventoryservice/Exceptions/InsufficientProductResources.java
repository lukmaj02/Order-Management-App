package com.App.inventoryservice.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InsufficientProductResources extends RuntimeException {
    public InsufficientProductResources(String productName, Integer substract){
        super(String.format("Insufficient product resources (%d) for product: %s", substract,productName));
    }
}
