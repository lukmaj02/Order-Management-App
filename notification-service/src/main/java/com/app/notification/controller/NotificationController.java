package com.app.notification.controller;

import com.app.notification.Model.Email;
import com.app.notification.Service.ISenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/notification")
@RequiredArgsConstructor
public class NotificationController{

    private final ISenderService ISenderService;
    @PostMapping("/send/mail")
    @ResponseStatus(HttpStatus.OK)
    public void sendNotification(@RequestBody Email email){
        ISenderService.sendMail(email);
    }
}
