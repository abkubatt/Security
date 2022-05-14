package com.example.security.controllers;

import com.example.security.models.dtos.AccountDto;
import com.example.security.models.json.SignIn;
import com.example.security.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/checkAccount")
    public AccountDto checkAccount(@RequestBody SignIn signIn){
        return accountService.checkUser(signIn);
    }

}
