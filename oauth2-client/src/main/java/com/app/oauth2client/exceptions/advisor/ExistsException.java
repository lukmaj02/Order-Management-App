package com.app.oauth2client.exceptions.advisor;

import com.app.oauth2client.exceptions.UserEmailExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.CONFLICT)
public class ExistsException {

    @ExceptionHandler(UserEmailExistsException.class)
    public String userEmailExistsExceptionHandler(UserEmailExistsException e){
        return e.getMessage();
    }
}
