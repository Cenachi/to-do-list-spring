package com.udemy.todolist.dto;

import com.udemy.todolist.entities.User;

public record UserDto(String email, String password, String name) {

    public User toUser() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);

        return user;
    }
}
