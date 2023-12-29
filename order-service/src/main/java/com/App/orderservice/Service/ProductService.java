package com.App.orderservice.Service;

import com.App.orderservice.Client.InventoryClient;
import com.App.orderservice.Model.Order;
import com.App.orderservice.Model.Product;
import com.App.orderservice.Repository.ProductRepository;
import com.App.orderservice.dtos.ProductExchange;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final ProductRepository productRepository;
    private final OrderService orderService;
    private final InventoryClient inventoryClient;

    @Override
    public List<Product> getOrderProducts(String orderId) {
        var order = orderService.getOrderById(orderId);
        return order.getOrderProducts();
    }

    @Override
    public Product getOrderProduct(String orderProductId) {
        return productRepository.findById(orderProductId).orElseThrow();
    }

    @Override
    public void addProductToOrder(ProductExchange productExchange, String orderId) {
        var order = orderService.getOrderById(orderId);
        var product = Product.builder()
                .productOrderId(UUID.randomUUID().toString())
                .productId(productExchange.productId())
                .productName(productExchange.productName())
                .quantity(productExchange.quantity())
                .productOrder(order)
                .build();
        productRepository.save(product);
    }
    @Override
    public void deleteProductFromOrder(String productOrderId) {
        productRepository.deleteById(productOrderId);
    }
    @Override
    public void updateProductToOrder(String productOrderId, Integer quantity) {
         var product = productRepository.findById(productOrderId).orElseThrow();
         product.setQuantity(quantity);
    }
}
