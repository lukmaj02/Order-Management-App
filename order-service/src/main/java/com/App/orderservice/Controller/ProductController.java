package com.App.orderservice.Controller;

import com.App.orderservice.Model.Product;
import com.App.orderservice.Service.IProductService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-service/order/product")
public class ProductController {

    private final IProductService productService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllOrderProducts(@RequestParam String orderId){
        return productService.getOrderProducts(orderId);
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getOrderProduct(@PathVariable String productOrderId){
        return productService.getOrderProduct(productOrderId);
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductToOrder(@RequestBody Product product, @RequestParam String productOrderId){
        productService.addProductToOrder(product, productOrderId);
    }

    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductFromOrder(@RequestParam String productOrderId){
        productService.deleteProductFromOrder(productOrderId);
    }

    @PutMapping("/{productOrderId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProductToOrder(@PathVariable String productOrderId, @RequestParam Integer quantity){
        productService.updateProductToOrder(productOrderId, quantity);
    }
}
