package com.App.inventoryservice.Controller;

import com.App.inventoryservice.Model.OrderExchange;
import com.App.inventoryservice.Model.Product;
import com.App.inventoryservice.Service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/inventory-service")
public class InventoryController {

    private final IProductService productService;

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String test(){
        return "UDALO SIE";
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@RequestParam String id){
        return productService.getProductById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.OK)
    public void processOrder(@RequestBody OrderExchange orderExchange){
        productService.processOrder(orderExchange);
    }

}
