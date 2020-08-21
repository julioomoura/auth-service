package com.julio.authservice.dto;

import com.julio.authservice.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String imageUrl;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.imageUrl = user.getImageUrl();
    }

    public static List<UserDTO> convert(List<User> users) {
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
