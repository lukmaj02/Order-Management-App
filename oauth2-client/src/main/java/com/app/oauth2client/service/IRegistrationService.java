package com.app.oauth2client.service;

import com.app.oauth2client.dtos.RegistrationBody;

public interface IRegistrationService {
    void registerClient(RegistrationBody user);
}
