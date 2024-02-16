package com.app.oauth2server.dtos;

import lombok.*;

@Builder
public record RegistrationDto(String firstName, String lastName, String email, String password){
}
