package com.example.security.services;

import com.example.security.models.dtos.AccountDto;
import com.example.security.models.dtos.UserDto;
import com.example.security.models.json.Register;

public interface UserService {

    UserDto save(Register register);

    UserDto findById(Long id);

    UserDto update(UserDto userDto);

    UserDto delete(UserDto userDto);
}
