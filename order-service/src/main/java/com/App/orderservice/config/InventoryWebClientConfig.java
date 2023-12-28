package com.App.orderservice.config;

import com.App.orderservice.Client.InventoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class InventoryWebClientConfig {
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;
    @Bean
    public WebClient inventoryWebClient(){
        return WebClient.builder()
                .baseUrl("http://inventory-service")
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
}
