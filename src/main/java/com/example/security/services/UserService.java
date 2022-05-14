package com.example.security.services;

import com.example.security.models.dtos.UserDto;

public interface UserService {

    UserDto save(UserDto userDto);

    UserDto findById(Long id);

    UserDto update(UserDto userDto);

    UserDto delete(UserDto userDto);
}
