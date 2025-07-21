package com.project.api.controller;

import com.project.api.service.dto.CreateApiRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/apis")
public class ApiController {
    //TODO: ADD SERVICE ATTRIBUTE AND CONSTRUCTOR AUTOWIRING


    @PostMapping("/")
    public void createApi(@Valid CreateApiRequest createApiRequest){
        //TODO: CALL SERVICE AND RETURN RESPONSE_ENTITY WITH API_ID AND HTTP OK
    }

    @GetMapping("/{id}")
    public void getApi(@PathVariable String id){
        //TODO: CALL SERVICE AND RETURN RESPONSE_ENTITY WITH API info AND HTTP OK
    }
}
