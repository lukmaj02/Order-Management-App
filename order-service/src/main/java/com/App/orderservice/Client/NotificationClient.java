package com.App.orderservice.Client;

import com.App.orderservice.dtos.Email;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
public interface NotificationClient {
    @PostExchange("/api/v1/notification/send/mail")
    ResponseEntity<Void> sendMail(@RequestBody Email email);
}
