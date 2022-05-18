package com.example.security.services;

import com.example.security.models.dtos.AccountDto;
import com.example.security.models.dtos.UserDto;

public interface AccountService {

    AccountDto save(AccountDto accountDto);
    AccountDto findByUser(UserDto userDto);
    AccountDto findByEmail(String email);

}
