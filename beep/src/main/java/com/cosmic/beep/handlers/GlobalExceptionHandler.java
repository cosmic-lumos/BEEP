package com.cosmic.beep.handlers;

import com.cosmic.beep.exceptions.MaximumRented;
import com.cosmic.beep.exceptions.ResourceNotFound;
import com.cosmic.beep.dtos.RestResponseErrorDto;
import com.cosmic.beep.exceptions.SignUpException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    RestResponseErrorDto handleResourceNotFound(ResourceNotFound ex){
        return new RestResponseErrorDto(
                ex.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    RestResponseErrorDto handleMaximumRented(MaximumRented ex){
        return new RestResponseErrorDto(
                ex.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    RestResponseErrorDto handleSignUpException(SignUpException ex){
        return new RestResponseErrorDto(
                ex.getMessage(),
                LocalDateTime.now()
        );
    }
}
