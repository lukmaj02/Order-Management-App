package com.app.oauth2client.exceptions;

import org.apache.logging.log4j.message.StringFormattedMessage;

public class UserEmailExistsException extends RuntimeException{
    public UserEmailExistsException(String email){
        super(String.format("User with email %s already exists!", email));
    }
}
