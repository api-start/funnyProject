package com.project.api.service.exception;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException(String message) {
        super(message);
    }
}
