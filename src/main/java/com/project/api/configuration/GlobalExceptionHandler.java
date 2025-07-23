package com.project.api.configuration;


import com.project.api.service.exception.ApiAlreadyCreatedException;
import com.project.api.service.exception.EmailAlreadyInUseException;
import com.project.api.service.exception.UsernameAlreadyInUseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler  {

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


}
