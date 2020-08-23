package com.julio.authservice.controller;

import com.julio.authservice.config.security.TokenService;
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

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Void> authenticate(@RequestBody @Valid AuthDTO authDTO) {
        UsernamePasswordAuthenticationToken login = authDTO.converter();
        try {
            Authentication authentication = authenticationManager.authenticate(login);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok().header("Authorization", token).build();
        } catch (AuthenticationException exception) {
            return ResponseEntity.badRequest().build();
        }
    }
}
