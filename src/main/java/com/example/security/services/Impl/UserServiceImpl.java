package com.example.security.services.Impl;

import com.example.security.dao.UserDao;
import com.example.security.mappers.RoleMapper;
import com.example.security.mappers.UserMapper;
import com.example.security.models.dtos.AccountDto;
import com.example.security.models.dtos.UserCodeDto;
import com.example.security.models.dtos.UserDto;
import com.example.security.models.entities.User;
import com.example.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    private UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public UserDto save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userDao.save(user));
    }

    @Override
    public UserDto findById(Long id) {
        User user = userDao.findById(id).orElse(null);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto findByUserCode(UserCodeDto userCodeDto) {
        return null;
    }
}
