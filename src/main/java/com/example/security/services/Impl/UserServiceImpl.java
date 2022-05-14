package com.example.security.services.Impl;

import com.example.security.dao.UserDao;
import com.example.security.mappers.RoleMapper;
import com.example.security.mappers.UserMapper;
import com.example.security.models.dtos.AccountDto;
import com.example.security.models.dtos.UserDto;
import com.example.security.models.entities.Account;
import com.example.security.models.entities.User;
import com.example.security.models.json.Register;
import com.example.security.services.AccountService;
import com.example.security.services.RoleService;
import com.example.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AccountService accountService;

    private RoleMapper roleMapper = RoleMapper.INSTANCE;
    @Autowired
    private RoleService roleService;
    private UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public UserDto save(Register register) {
        User user = new User();
        user.setActive(true);
        user.setEmail(register.getEmail());
        user.setName(register.getName());
        user.setPhone(register.getPhone());
        user.setRole(roleMapper.toRole(roleService.findById(register.getRoleId())));

        User savedUser = userDao.save(user);

        AccountDto accountDto = new AccountDto();
        accountDto.setActive(true);
        accountDto.setLogin(register.getEmail());
        accountDto.setPassword(register.getPassword());
        accountDto.setUser(userMapper.toUserDto(savedUser));
        accountService.save(accountDto);

        return userMapper.toUserDto(user);
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
