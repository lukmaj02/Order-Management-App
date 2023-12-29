package com.App.inventoryservice.Controller;

import com.App.inventoryservice.Model.ProductDto;
import com.App.inventoryservice.Model.ProductExchange;
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
    public void addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.OK)
    public void processProducts(@RequestBody List<ProductExchange> products){
        productService.processProducts(products);
    }

    @PostMapping("/product-availability")
    @ResponseStatus(HttpStatus.OK)
    public boolean checkResourceProductAvailability(@RequestBody ProductExchange productExchange){
        return productService.checkProductResource(productExchange);
    }

}
