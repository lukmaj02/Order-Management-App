package com.app.pickupservice.Exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String id){
        super("Order with id %s not found".formatted(id));
    }

}
