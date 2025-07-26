package com.project.api.controller;

import com.project.api.model.Api;
import com.project.api.model.security.AccountUserDetails;
import com.project.api.service.ApiService;
import com.project.api.service.dto.CreateApiRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/apis")
public class ApiController {
    private ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }


    @PostMapping
    public ResponseEntity<String> createApi(@Valid @RequestBody CreateApiRequest createApiRequest, @AuthenticationPrincipal AccountUserDetails auth){
        UUID accountId = auth.getId();
        String id = apiService.createApi(accountId,createApiRequest);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Api> getApi(@PathVariable String id){
        Api api = apiService.getApi(id);
        return new ResponseEntity<>(api,HttpStatus.OK);
        //TODO: SHOULD USE DTOS TO EXPOSE INFORMATION
    }
}
