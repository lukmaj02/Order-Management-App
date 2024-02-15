package com.app.oauth2server.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
