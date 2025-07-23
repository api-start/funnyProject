package com.project.api.service.dto;

import com.project.api.model.annotation.NotNullNotWhitespace;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAccountRequest {
    @NotNullNotWhitespace(message = "Username cannot contain spaces or be null")
    @Size(min = 5, message = "Username must be min 5 characters")
    @Size(max = 50, message = "Username must be max 50 characters")
    private String username;

    @NotNullNotWhitespace(message = "Email cannot contain spaces or be null")
    @Size(min = 10, message = "Email must be min 10 characters")
    @Size(max = 255, message = "Email must be max 255 characters")
    @Email
    private String email; // NO SE PUEDE CAMBIAR

    @NotBlank
    @Size(min = 8, message = "Password must be min 8 characters")
    @Size(max = 255, message = "Password must be max 255 characters")
    private String password;

    public CreateAccountRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
