package com.clientservice.Controller;

import com.clientservice.Dto.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
public class RegistrationController {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private final String registerUrl = "/admin/realms/order-management-app/users";

    private final WebClient keycloak;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegistrationRequest user){}

}
