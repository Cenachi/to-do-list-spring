package com.udemy.todolist.controller;

import com.udemy.todolist.dto.RegisterDTO;
import com.udemy.todolist.entities.User;
import com.udemy.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    UserService userService;
    AuthenticationManager authenticationManager;

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO registerDTO) {
        try {
            User user = userService.register(registerDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody RegisterDTO registerDTO) {
        Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(
                registerDTO.getEmail(),
                registerDTO.getPassword()
        );

        Authentication authResponse = authenticationManager.authenticate(authentication);

        if (authResponse.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
