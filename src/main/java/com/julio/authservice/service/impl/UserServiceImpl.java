package com.julio.authservice.service.impl;

import com.julio.authservice.model.User;
import com.julio.authservice.repository.UserRepository;
import com.julio.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
