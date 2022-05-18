package com.example.security.services;

import com.example.security.models.request.SignInRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<?> signIn(SignInRequest signInRequest);

    ResponseEntity<?> logIn(String login, String password);

   ResponseEntity sendCode(String email);

    ResponseEntity<?> confirmation(String email, String code);
}
