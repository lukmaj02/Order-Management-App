package com.App.inventoryservice.Service;

import com.App.inventoryservice.Exceptions.InsufficientProductResources;
import com.App.inventoryservice.Exceptions.ProductNotFoundException;
import com.App.inventoryservice.Model.ProductDto;
import com.App.inventoryservice.Model.ProductExchange;
import com.App.inventoryservice.Model.Product;
import com.App.inventoryservice.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void addProduct(ProductDto productDto) {
        var product = Product.builder()
                .productId(UUID.randomUUID().toString())
                .productName(productDto.productName())
                .quantity(productDto.quantity())
                .build();
        product.setProductId(UUID.randomUUID().toString());
        productRepository.save(product);
    }



    @Transactional
    @Override
    public void processProducts(List<ProductExchange> products) {
        for (ProductExchange product : products){
            var productInDb = productRepository
                    .findById(product.productId())
                    .orElseThrow(() -> new ProductNotFoundException(product.productId()));
            if(product.quantity() > productInDb.getQuantity())
                throw new InsufficientProductResources(productInDb.getProductName()
                        ,product.quantity()-productInDb.getQuantity());
            productInDb.setQuantity(productInDb.getQuantity() - product.quantity());
        }
    }

    @Override
    public boolean checkProductResource(ProductExchange productExchange) {
        var product = productRepository.findById(productExchange.productId())
                .orElseThrow(() -> new ProductNotFoundException(productExchange.productId()));
        return productExchange.quantity() <= product.getQuantity();
    }
}
