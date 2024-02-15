package com.app.oauth2server.dtos;

import lombok.*;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email;
    private String password;
}
