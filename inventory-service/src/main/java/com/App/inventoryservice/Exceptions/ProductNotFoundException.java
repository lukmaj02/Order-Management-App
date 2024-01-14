package com.App.inventoryservice.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String productId){
        super(String.format("Product with id: %s not found",productId));
    }
}
