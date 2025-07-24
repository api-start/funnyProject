package com.project.api.configuration;


import com.project.api.service.exception.ApiAlreadyCreatedException;
import com.project.api.service.exception.EmailAlreadyInUseException;
import com.project.api.service.exception.UsernameAlreadyInUseException;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiAlreadyCreatedException.class)
    public ProblemDetail handleApiAlreadyCreatedException(ApiAlreadyCreatedException e){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Bad request");
        problemDetail.setDetail("The api already exists");
        return problemDetail;
    }

    @ExceptionHandler(UsernameAlreadyInUseException.class)
    public ErrorResponse handleUsernameAlreadyInUse(UsernameAlreadyInUseException ex){
        return ErrorResponse.builder(ex, HttpStatus.BAD_REQUEST, ex.getMessage())
                .title("Username conflict")
                .detail("Username is already in use by other user")
                .build();
    }

    @ExceptionHandler(EmailAlreadyInUseException.class)
    public ErrorResponse handleEmailAlreadyInUse(EmailAlreadyInUseException ex){
        return ErrorResponse.builder(ex, HttpStatus.BAD_REQUEST, ex.getMessage())
                .title("Email conflict")
                .detail("The email provided is already in use by another account")
                .build();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Bad Request");
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError e : ex.getFieldErrors()) {
            validationErrors.put(e.getField(), e.getDefaultMessage());
        }
        problemDetail.setDetail("Invalid Parameters " + validationErrors);
        return new ResponseEntity<Object>(problemDetail, HttpStatus.BAD_REQUEST);

    }
}
