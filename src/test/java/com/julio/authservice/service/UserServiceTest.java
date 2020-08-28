package com.julio.authservice.service;

import static org.junit.jupiter.api.Assertions.*;

import com.julio.authservice.model.User;
import com.julio.authservice.repository.UserRepository;
import com.julio.authservice.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = {UserServiceImpl.class})

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void validateInjection() {
        assertNotNull(userService);
    }

    @Test
    void validateFindAllUsersIsNotEmpty() {
        List<User> mockedUsers = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setName("name");
        mockedUsers.add(user);
        Mockito.when(userService.findAll())
                .thenReturn(mockedUsers);

        List<User> users = userService.findAll();
        assertFalse(users.isEmpty());
    }
}
