package com.julio.authservice.config.validation;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsernameNotFoundException.class)
    public ErrorDTO usernameNotFoundException(UsernameNotFoundException exception) {
        return new ErrorDTO(exception.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public ErrorDTO authenticationException(AuthenticationException exception) {
        return new ErrorDTO(exception.getMessage(), HttpStatus.UNAUTHORIZED.value());
    }

}
