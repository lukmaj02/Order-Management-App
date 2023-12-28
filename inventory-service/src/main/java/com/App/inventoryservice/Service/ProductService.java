package com.App.inventoryservice.Service;

import com.App.inventoryservice.Model.Product;
import com.App.inventoryservice.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public void addProduct(Product product) {
        product.setProductId(UUID.randomUUID().toString());
        productRepository.save(product);
    }
}
