package com.careerit.cbook.service.exception;

public class ContactAlreadyExistsException extends RuntimeException{

    public ContactAlreadyExistsException(String message){
        super(message);
    }
}
