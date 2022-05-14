package com.example.security.models.dtos;

import com.example.security.models.enums.Roles;
import lombok.Data;

@Data
public class RoleDto {
    Long id;
    Roles role;
}
