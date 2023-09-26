package com.careerit.cbook.controller;

import com.careerit.cbook.dto.ErrorMessage;
import com.careerit.cbook.service.exception.ContactAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ContactAlreadyExistsException.class})
    public ResponseEntity<ErrorMessage> handleContactAlreadyExistsException(Exception ex){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(ex.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.badRequest().body(errorMessage);
    }

}
