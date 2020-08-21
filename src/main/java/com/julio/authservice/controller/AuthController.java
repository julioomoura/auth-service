package com.julio.authservice.controller;

import com.julio.authservice.dto.AuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<Void> authenticate(@RequestBody AuthDTO authDTO) {
        UsernamePasswordAuthenticationToken login = authDTO.converter();
        try {
            authenticationManager.authenticate(login);
            return ResponseEntity.ok().build();
        } catch (AuthenticationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}
