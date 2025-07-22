package com.project.api.service.exception;

public class ApiAlreadyCreatedException extends RuntimeException{
    public ApiAlreadyCreatedException(String message) {
        super(message);
    }
}
