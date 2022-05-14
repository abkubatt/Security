package com.example.security.services.Impl;

import com.example.security.dao.UserDao;
import com.example.security.mappers.UserMapper;
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
        User user = userMapper.toUser(userDto);
        user.setActive(true);
        User savedUser = userDao.save(user);
        return userMapper.toUserDto(savedUser);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userDao.findById(id).orElse(null);
        return userMapper.toUserDto(user);
    }

    @Override
    public UserDto update(UserDto userDto) {
        boolean isExists = userDao.existsById(userDto.getId());
        if (!isExists){
            return null;
        }
        else{
            User user = userMapper.toUser(userDto);
            User updatedUser = userDao.save(user);
            return userMapper.toUserDto(updatedUser);
        }
    }

    @Override
    public UserDto delete(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        user.setActive(false);
        UserDto deletedUser = update(userMapper.toUserDto(user));
        return deletedUser;
    }
}
