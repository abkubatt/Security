package com.example.security.services.Impl;

import com.example.security.models.dtos.UserCodeDto;
import com.example.security.models.dtos.UserDto;
import com.example.security.services.UserCodeService;
import org.springframework.stereotype.Service;

@Service
public class UserCodeServiceImpl implements UserCodeService {
    @Override
    public UserCodeDto findByUser(UserDto userDto) {
        return null;
    }
}
