package com.app.oauth2server.service;

import com.app.oauth2server.Iservice.IRegstrationService;
import com.app.oauth2server.dtos.RegistrationDto;
import com.app.oauth2server.enums.Role;
import com.app.oauth2server.exceptions.UserEmailExistsException;
import com.app.oauth2server.model.User;
import com.app.oauth2server.model.UserRoles;
import com.app.oauth2server.repository.UserRepository;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService implements IRegstrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void registerUser(RegistrationDto registrationDto) {
        if(registrationDto.email().isEmpty())
            throw new UsernameNotFoundException("Empty email!");

        if(userRepository.existsByEmail(registrationDto.email()))
            throw new UserEmailExistsException(registrationDto.email());

        var userRoles = UserRoles.builder()
                .id(UUID.randomUUID().toString())
                .role(Role.USER)
                .build();

        userRepository.save(User.builder()
                 .userId(UUID.randomUUID().toString())
                .firstName(registrationDto.firstName())
                .lastName(registrationDto.lastName())
                .password(passwordEncoder.encode(registrationDto.password()))
                .roles(List.of(userRoles))
                .enabled(false)
                .build());
    }
}
