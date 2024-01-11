package com.app.notification.controller;

import com.app.notification.Model.Sendable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/notification")
@RequiredArgsConstructor
public class NotificationController{

    private final NotificationController notificationController;
    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public void sendNotification(@RequestBody Sendable message){
        notificationController.sendNotification(message);
    }
}
