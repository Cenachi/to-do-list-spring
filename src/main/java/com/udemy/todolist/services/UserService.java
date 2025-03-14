package com.udemy.todolist.services;

import com.udemy.todolist.dto.RegisterDTO;
import com.udemy.todolist.entities.User;
import com.udemy.todolist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User register(RegisterDTO registerDTO) {

        User user = new User();
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());

        return userRepository.save(user);
    }
}
