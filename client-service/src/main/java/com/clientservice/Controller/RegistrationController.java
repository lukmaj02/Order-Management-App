package com.clientservice.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RegistrationController {

    private final WebClient keycloak;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(){
        HttpHeaders
        keycloak.get()
                .headers()
    }

}
