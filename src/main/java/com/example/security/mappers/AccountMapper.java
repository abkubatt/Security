package com.example.security.mappers;

import com.example.security.models.dtos.AccountDto;
import com.example.security.models.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper extends BaseMapper<Account ,AccountDto>{
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

}
