package com.project.api.controller;

import com.project.api.service.dto.CreateAccountRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/accounts")
public class AccountController {
    //TODO: ADD SERVICE ATTRIBUTE AND CONSTRUCTOR AUTOWIRING


    @PostMapping("/")
    public ResponseEntity<String> createAccount(@Valid CreateAccountRequest createAccountRequest){
        //TODO: CALL SERVICE
        return ResponseEntity.ok("Account created successfully");
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> getAccount(@Valid @PathVariable String id){
        //TODO: CALL SERVICE AND RETURN ACCOUNT INFO
        return ResponseEntity.ok("Account created successfully");
    }
}
