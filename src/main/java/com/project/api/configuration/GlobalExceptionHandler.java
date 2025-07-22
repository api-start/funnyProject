package com.project.api.configuration;


import com.project.api.service.exception.ApiAlreadyCreatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
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


}
