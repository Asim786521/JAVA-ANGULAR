package com.example.ecommerce.model;


import org.springframework.http.HttpStatus;

public class AuthenticationResponse {


    private String token;




    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
