package com.App.orderservice.config;

import com.App.orderservice.Client.InventoryClient;
import com.App.orderservice.Client.NotificationClient;
import com.App.orderservice.Client.PickupClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class OrderConfiguration {
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;
    @Value("${services.path.notification-service}")
    private String NOTIFICATION_SERVICE_PATH;
    @Value("${services.path.inventory-service}")
    private String INVENTORY_SERVICE_PATH;
    @Value("${services.path.pickup-service}")
    private String PICKUP_SERVICE_PATH;

    @Bean
    public WebClient inventoryWebClient(){
        return WebClient.builder()
                .baseUrl(INVENTORY_SERVICE_PATH)
                .filter(filterFunction)
                .build();
    }
    @Bean
    public WebClient notificationWebClient(){
        return WebClient.builder()
                .baseUrl(NOTIFICATION_SERVICE_PATH)
                .filter(filterFunction)
                .build();
    }

    @Bean
    public WebClient pickupWebClient(){
        return WebClient.builder()
                .baseUrl(PICKUP_SERVICE_PATH)
                .filter(filterFunction)
                .build();
    }
    @Bean
    public InventoryClient inventoryClient(){
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory
                        .builderFor(WebClientAdapter.create(inventoryWebClient()))
                        .build();
        return httpServiceProxyFactory.createClient(InventoryClient.class);
    }
    @Bean
    public NotificationClient notificationClient(){
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory
                        .builderFor(WebClientAdapter.create(notificationWebClient()))
                        .build();
        return httpServiceProxyFactory.createClient(NotificationClient.class);
    }

    @Bean
    public PickupClient pickupClient(){
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory
                        .builderFor(WebClientAdapter.create(pickupWebClient()))
                        .build();
        return httpServiceProxyFactory.createClient(PickupClient.class);
    }
}
