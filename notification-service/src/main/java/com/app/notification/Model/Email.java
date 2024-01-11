package com.app.notification.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Email{
    private String toEmail;
    private String message;
    private String title;

}
