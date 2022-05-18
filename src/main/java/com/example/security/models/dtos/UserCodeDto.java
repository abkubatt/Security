package com.example.security.models.dtos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserCodeDto {
    Long id;
    private UserDto user;
    String code;
    Date sendDate;
    boolean confirm;
}
