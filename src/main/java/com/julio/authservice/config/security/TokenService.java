package com.julio.authservice.config.security;

import com.julio.authservice.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + expiration);
        User user = (User) authentication.getPrincipal();
        return Jwts.builder()
            .setIssuer("auth-service")
            .setIssuedAt(now)
            .setExpiration(expirationDate)
            .setSubject(user.getId().toString())
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }

    public boolean tokenValidate(String token) {
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch(Exception exception) {
            return false;
        }
    }

    public Long getSubject(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }
}
