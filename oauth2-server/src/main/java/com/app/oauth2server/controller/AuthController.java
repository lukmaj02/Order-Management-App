package com.app.oauth2server.controller;

import com.app.oauth2server.dtos.RegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AuthController {

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }
}
