package com.example.security.controllers;

import com.example.security.models.request.SignInRequest;
import com.example.security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest){
        return authService.signIn(signInRequest);
    }
    @GetMapping("/login")
    public ResponseEntity<?> logIn(@RequestParam String login, @RequestParam String password){
        return authService.logIn(login,password);
    }
    @GetMapping("/confirm")
    public ResponseEntity<?> confirm(@RequestParam String email, @RequestParam String code){
        return authService.confirmation(email,code);
    }

    @PostMapping("/sendCode")
    public ResponseEntity<?> sendCode(@RequestParam String email){
        return authService.sendCode(email);
    }
}
