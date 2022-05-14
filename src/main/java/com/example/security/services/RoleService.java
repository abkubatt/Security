package com.example.security.services;

import com.example.security.models.dtos.RoleDto;

public interface RoleService {

    RoleDto save(RoleDto roleDto);

    RoleDto findById(Long id);

    RoleDto update(RoleDto roleDto);

    boolean delete(RoleDto roleDto);
}
