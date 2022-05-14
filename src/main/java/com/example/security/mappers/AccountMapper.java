package com.example.security.mappers;

import com.example.security.models.dtos.AccountDto;
import com.example.security.models.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account toAccount(AccountDto accountDto);

    AccountDto toAccountDto(Account account);

    List<Account> toAccountList(List<AccountDto> accountDtos);

    List<AccountDto> toAccountDtoList(List<Account> accounts);
}
