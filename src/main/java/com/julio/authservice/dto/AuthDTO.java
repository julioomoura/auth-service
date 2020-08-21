package com.julio.authservice.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthDTO {
    private String email;
    private String password;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(this.email, this.password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
