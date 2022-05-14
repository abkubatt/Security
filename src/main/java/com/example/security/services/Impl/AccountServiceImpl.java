package com.example.security.services.Impl;

import com.example.security.dao.AccountDao;
import com.example.security.mappers.AccountMapper;
import com.example.security.models.dtos.AccountDto;
import com.example.security.models.entities.Account;
import com.example.security.models.json.SignIn;
import com.example.security.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    private AccountMapper accountMapper = AccountMapper.INSTANCE;
    @Override
    public AccountDto save(AccountDto accountDto) {
        Account account = accountMapper.toAccount(accountDto);
        account.setActive(true);
        Account savedAccount = accountDao.save(account);
        return accountMapper.toAccountDto(savedAccount);
    }

    @Override
    public AccountDto findById(Long id) {
        Account account = accountDao.findById(id).orElse(null);
        return accountMapper.toAccountDto(account);
    }

    @Override
    public AccountDto update(AccountDto accountDto) {
        boolean isExists = accountDao.existsById(accountDto.getId());
        if (!isExists){
            return null;
        }else{
            Account account = accountMapper.toAccount(accountDto);
            Account updatedAccount = accountDao.save(account);
            return accountMapper.toAccountDto(updatedAccount);
        }
    }

    @Override
    public AccountDto delete(AccountDto accountDto) {
        Account account = accountMapper.toAccount(accountDto);
        account.setActive(false);
        AccountDto deletedAccount = update(accountMapper.toAccountDto(account));
        return deletedAccount;
    }

    @Override
    public AccountDto checkUser(SignIn signIn) {
        Account account = new Account();
        account.setLogin(signIn.getLogin());
        account.setPassword(signIn.getPassword());
        Account checkingAccount = accountDao.checkAccount(account.getLogin(), account.getPassword());
        if (checkingAccount == null){
            return null;
        }else {
            return accountMapper.toAccountDto(checkingAccount);
        }
    }
}
