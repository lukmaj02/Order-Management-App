package com.app.notification.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Email implements Sendable{
    private String userEmail;
    private String message;
    private String title;


}
