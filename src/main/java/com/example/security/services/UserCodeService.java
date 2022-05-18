package com.example.security.services;

import com.example.security.models.dtos.UserCodeDto;
import com.example.security.models.dtos.UserDto;

public interface UserCodeService {

    UserCodeDto findByUser(UserDto userDto);
}
