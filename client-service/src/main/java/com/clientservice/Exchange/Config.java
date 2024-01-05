package com.clientservice.Exchange;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

    @Bean
    WebClient keycloak(){
        return WebClient.builder()
                .baseUrl("http://keycloak-service:8080")
                .build();
    }
}
