package com.project.api.model;
import java.time.LocalDate;
import java.util.UUID;

public class Account {

    private UUID id;
    private String username;
    private String email; // NO SE PUEDE CAMBIAR
    private String password;
    private boolean enabled;
    private LocalDate createdDate;


    private Account(UUID id, String username, String email, String password, boolean enabled, LocalDate createdDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.createdDate = createdDate;
    }

    public static Account createNew(UUID id, String username, String email, String password) {
        return new Account(
                id,
                username,
                email,
                password,
                true,
                LocalDate.now()
        );
    }

    public static Account fromDatabase(UUID id, String username, String email,
                                       String password, boolean enabled, LocalDate createdDate) {
        return new Account(id, username, email, password, enabled, createdDate);
    }

    public void disable(){
        enabled = false;
    }

    public void enable(){
        enabled = true;
    }

    public UUID getId() {
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
