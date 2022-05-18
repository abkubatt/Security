package com.example.security.models.dtos;

import com.example.security.models.entities.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AccountDto {
    Long id;
    String login;
    String password;
    UserDto user;
}
