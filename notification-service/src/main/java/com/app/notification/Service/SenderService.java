package com.app.notification.Service;

import com.app.notification.Model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SenderService implements ISenderService {
    private final JavaMailSender javaMailSender;
    @Value("${host.mail.username}")
    private String HOST;

    @Autowired
    public SenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(Email email) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(HOST);
        mail.setSubject(email.title());
        mail.setText(email.message());
        mail.setTo(email.toEmail());
        javaMailSender.send(mail);
    }
}
