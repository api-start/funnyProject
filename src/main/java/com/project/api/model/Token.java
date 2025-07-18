package com.project.api.model;

public class Token {
    private String idToken;
    private String token;
    private String idApi;
    private String idAccount;
    private boolean enabled;

    public Token(String idToken, String token, String idApi, String idAccount, boolean enabled) {
        this.idToken = idToken;
        this.token = token;
        this.idApi = idApi;
        this.idAccount = idAccount;
        this.enabled = enabled;
    }

    public void enable(){
        this.enabled = true;
    }
    public void disable(){
        this.enabled = false;
    }

    public String getIdToken() {
        return idToken;
    }

    public String getToken() {
        return token;
    }

    public String getIdApi() {
        return idApi;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public boolean isEnabled() {
        return enabled;
    }


}
