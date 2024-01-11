package com.app.notification.Service;

import com.app.notification.Model.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SenderService implements ISenderService {
    private final JavaMailSender javaMailSender;

    @Override
    public void sendMail(Email mail) {

    }
}
