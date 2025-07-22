package com.project.api.controller;

import com.project.api.model.Api;
import com.project.api.service.ApiService;
import com.project.api.service.dto.CreateApiRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/apis")
public class ApiController {
    private ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }


    @PostMapping("/")
    public ResponseEntity<String> createApi(@Valid CreateApiRequest createApiRequest){
        //TODO: ADD AUTHENTICATION SO CAN PASS ACCOUNT_ID
        String id = apiService.createApi(accountId,createApiRequest);
        return new ResponseEntity(id, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Api> getApi(@PathVariable String id){
        Api api = apiService.getApi(id);
        return new ResponseEntity<>(api,HttpStatus.OK);
        //TODO: SHOULD USE DTOS TO EXPOSE INFORMATION
    }
}
