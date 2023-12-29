package com.App.inventoryservice.Service;

import com.App.inventoryservice.Exceptions.InsufficientProductResources;
import com.App.inventoryservice.Exceptions.ProductNotFoundException;
import com.App.inventoryservice.Model.OrderExchange;
import com.App.inventoryservice.Model.Product;
import com.App.inventoryservice.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.InsufficientResourcesException;
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

    @Transactional
    @Override
    public void processOrder(OrderExchange orderExchange) {
        var products = orderExchange.products();
        for (Product product : products){
            var productInDb = productRepository
                    .findById(product.getProductId())
                    .orElseThrow(() -> new ProductNotFoundException(product.getProductId()));
            if(product.getQuantity() > productInDb.getQuantity())
                throw new InsufficientProductResources();

            productInDb.setQuantity(productInDb.getQuantity() - product.getQuantity());
        }
    }
}
