package com.udemy.todolist.controller;

import com.udemy.todolist.dto.UserDto;
import com.udemy.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam Map<String, String> body) {
        UserDto userDto = new UserDto(body.get("email"), body.get("password"), body.get("name"));
        userService.register(userDto);
        return "login";
    }
}
