package com.julio.authservice.controller;

import com.julio.authservice.model.User;
import com.julio.authservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        User user = new User();
        user.setId(12L);
        user.setEmail("valid@email.com");
        user.setPassword("$2a$10$PAeHtcH9qcXzFOjLBRk9dOM4L49Au64H3jhVWkyFx9cCK4DaO1IgW");
        Mockito.when(userRepository.findByEmail("invalid@email.com")).thenReturn(Optional.empty());
        Mockito.when(userRepository.findByEmail("valid@email.com")).thenReturn(Optional.of(user));
    }

    @Test
    public void shouldReturn400WhenAuthenticationDataIsIncorrect() throws Exception {
        URI uri = new URI("/auth");
        String json = "{\"email\":\"invalid@email.com\", \"password\":\"1234\"}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    public void shouldReturn200WhenUserIsAuthenticated() throws Exception {
        URI uri = new URI("/auth");
        String json = "{\"email\":\"valid@email.com\", \"password\":\"password\"}";

        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}
