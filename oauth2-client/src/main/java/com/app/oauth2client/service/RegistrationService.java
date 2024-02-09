package com.app.oauth2client.service;

import com.app.oauth2client.dtos.RegistrationBody;
import com.app.oauth2client.exceptions.UserEmailExistsException;
import com.app.oauth2client.model.Client;
import com.app.oauth2client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService implements IRegistrationService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public void registerClient(RegistrationBody user) {
        if(clientRepository.existsByEmail(user.email())) throw new UserEmailExistsException(user.email());
        clientRepository.save(Client.builder()
                        .id(UUID.randomUUID().toString())
                        .email(user.email())
                        .password(passwordEncoder.encode(user.password()))
                        .enabled(false)
                        .role("user")//todo
                        .build());
    }
}
