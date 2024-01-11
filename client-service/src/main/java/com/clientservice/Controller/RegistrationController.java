package com.clientservice.Controller;

import com.clientservice.Dto.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
public class RegistrationController {
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @Value("user.registration.url")
    private final String registerUrl;

    private final WebClient keycloak;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegistrationRequest user){

    }

}
