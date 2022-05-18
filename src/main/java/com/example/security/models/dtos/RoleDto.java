package com.example.security.models.dtos;

import com.example.security.models.enums.Roles;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class RoleDto {
    Long id;
    Roles role;
}
