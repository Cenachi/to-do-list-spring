package com.udemy.todolist.controller;

import com.udemy.todolist.dto.RegisterDTO;
import com.udemy.todolist.entities.User;
import com.udemy.todolist.repositories.UserRepository;
import com.udemy.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public Map<String, String> postRegister(@RequestBody RegisterDTO registerDTO) {
        Map<String, String> response = new HashMap<>();

        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            response.put("status", "error");
            return response;
        }

        User user = new User();
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());

        userRepository.save(user);

        response.put("status", "success");
        return response;
    }
}
