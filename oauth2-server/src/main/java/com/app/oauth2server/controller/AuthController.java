package com.app.oauth2server.controller;

import com.app.oauth2server.Iservice.IRegstrationService;
import com.app.oauth2server.dtos.RegistrationDto;
import com.app.oauth2server.dtos.UserDto;
import com.app.oauth2server.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final IRegstrationService regstrationService;


    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
         //create model object to store form data
        model.addAttribute("user", RegistrationDto.builder().build());
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") RegistrationDto registrationDto,
                               BindingResult result,
                               Model model){
        regstrationService.registerUser(registrationDto);

        if(result.hasErrors()){
            model.addAttribute("user", registrationDto);
            return "/register";
        }
        return "redirect:/register?success";
    }
}
