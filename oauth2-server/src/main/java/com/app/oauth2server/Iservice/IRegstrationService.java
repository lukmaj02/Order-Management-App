package com.app.oauth2server.Iservice;

import com.app.oauth2server.dtos.RegistrationDto;
import com.app.oauth2server.model.User;

public interface IRegstrationService {
    void registerUser(RegistrationDto registrationDto);
}
