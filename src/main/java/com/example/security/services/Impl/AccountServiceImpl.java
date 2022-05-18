package com.example.security.services.Impl;

import com.example.security.dao.AccountDao;
import com.example.security.mappers.AccountMapper;
import com.example.security.mappers.UserMapper;
import com.example.security.models.dtos.AccountDto;
import com.example.security.models.dtos.UserDto;
import com.example.security.models.entities.Account;
import com.example.security.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    private AccountMapper accountMapper = AccountMapper.INSTANCE;
    private UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public AccountDto save(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        return accountMapper.toDto(accountDao.save(account));
    }

    @Override
    public AccountDto findByUser(UserDto userDto) {
        Account account = accountDao.findByUser(userMapper.toEntity(userDto));
        return accountMapper.toDto(account);
    }

    @Override
    public AccountDto findByEmail(String email) {
        Account account = accountDao.findByLogin(email);
        return accountMapper.toDto(account);
    }
}
