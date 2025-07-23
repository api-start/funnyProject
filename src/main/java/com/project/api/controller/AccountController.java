package com.project.api.controller;

import com.project.api.model.Account;
import com.project.api.service.AccountService;
import com.project.api.service.dto.CreateAccountRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/")
    public ResponseEntity<String> createAccount(@Valid @RequestBody CreateAccountRequest createAccountRequest){
        String id = accountService.createUser(createAccountRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") String id){
        Account account = accountService.getAccount(id);
        return ResponseEntity.ok(account);
    }
}
