package com.App.orderservice.Exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String id){
        super("Order with id %s not found".formatted(id));
    }
}
