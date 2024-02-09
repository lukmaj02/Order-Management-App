package com.app.oauth2client.controller;

import com.app.oauth2client.dtos.RegistrationBody;
import com.app.oauth2client.service.IRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private final IRegistrationService registrationService;
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody RegistrationBody user){
        registrationService.registerClient(user);
    }
}
