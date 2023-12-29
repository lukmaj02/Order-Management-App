package com.App.inventoryservice.Service;

import com.App.inventoryservice.Model.ProductDto;
import com.App.inventoryservice.Model.ProductExchange;
import com.App.inventoryservice.Model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(String id);
    void addProduct(ProductDto productDto);
    void processProducts(List<ProductExchange> products);
    boolean checkProductResource(ProductExchange productExchange);
}
