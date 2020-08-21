package com.julio.authservice.config.security;

import com.julio.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        return userRepository.findByUsername(email).orElseThrow(() ->
            new UsernameNotFoundException("User not Found")
        );
    }

    public UserDetails loadUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("User Not Found")
        );
    }
}
