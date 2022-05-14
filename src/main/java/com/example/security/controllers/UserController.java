package com.example.security.controllers;

import com.example.security.models.dtos.UserDto;
import com.example.security.models.json.Register;
import com.example.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public UserDto registration(@RequestBody Register register){
        return userService.save(register);
    }
}
