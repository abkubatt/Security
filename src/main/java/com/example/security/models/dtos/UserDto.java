package com.example.security.models.dtos;

import com.example.security.models.entities.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserDto {
    Long id;
    String name;
    String phone;
    String email;
    RoleDto role;
    boolean confirm;
}
