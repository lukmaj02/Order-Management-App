package com.App.inventoryservice.Exceptions.Handler;

import com.App.inventoryservice.Exceptions.InsufficientProductResources;
import com.App.inventoryservice.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InventoryControllerHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ProductNotFoundAdvice(ProductNotFoundException e){
        return e.getMessage();
    }
    @ExceptionHandler(InsufficientProductResources.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String InsufficientProductResourceAdvice(InsufficientProductResources e){
        return e.getMessage();
    }
}
