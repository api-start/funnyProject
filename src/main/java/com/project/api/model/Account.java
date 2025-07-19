package com.project.api.model;

import com.project.api.model.annotation.NotNullNotWhitespace;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public class Account {

    private String id;
    private String username;
    private String email; // NO SE PUEDE CAMBIAR
    private String password;
    private boolean enabled;
    private LocalDate createdDate;


    private Account(String id, String username, String email, String password, boolean enabled, LocalDate createdDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.createdDate = createdDate;
    }

    public static Account createNew(String id, String username, String email, String password) {
        return new Account(
                id,
                username,
                email,
                password,
                true,
                LocalDate.now()
        );
    }

    public static Account fromDatabase(String id, String username, String email,
                                       String password, boolean enabled, LocalDate createdDate) {
        return new Account(id, username, email, password, enabled, createdDate);
    }

    public void disable(){
        enabled = false;
    }

    public void enable(){
        enabled = true;
    }

    public String getId() {
        return id;
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

    public boolean isEnabled() {
        return enabled;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }
}
