package com.eventclean.Event.Clean.infrastructure.exceptions;

public class DuplicateEventException extends RuntimeException{
    public DuplicateEventException(String message){
        super(message);
    }

}
