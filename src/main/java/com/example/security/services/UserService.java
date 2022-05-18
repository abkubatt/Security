package com.example.security.services;

import com.example.security.models.dtos.AccountDto;
import com.example.security.models.dtos.UserCodeDto;
import com.example.security.models.dtos.UserDto;
public interface UserService {

    UserDto save(UserDto userDto);

    UserDto findById(Long id);

    UserDto findByUserCode(UserCodeDto userCodeDto);


}
