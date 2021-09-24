package com.quickwin.savedocument.security.models;

public class AuthenticationRequest {
    private String userNames;
    private String password;

    public AuthenticationRequest() {

    }

    public AuthenticationRequest(String userNames, String password) {
        this.userNames = userNames;
        this.password = password;
    }

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
