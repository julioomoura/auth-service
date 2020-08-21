package com.julio.authservice.service;

import com.julio.authservice.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
