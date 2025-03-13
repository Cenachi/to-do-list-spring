package com.udemy.todolist.services;

import com.udemy.todolist.dto.UserDto;
import com.udemy.todolist.entities.User;
import com.udemy.todolist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User register(UserDto userDto) {
        return userRepository.save(userDto.toUser());
    }
}
