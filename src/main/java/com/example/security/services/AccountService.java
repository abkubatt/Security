package com.example.security.services;

import com.example.security.models.dtos.AccountDto;

public interface AccountService {

    AccountDto save(AccountDto accountDto);

    AccountDto findById(Long id);

    AccountDto update(AccountDto accountDto);

    AccountDto delete(AccountDto accountDto);

}
