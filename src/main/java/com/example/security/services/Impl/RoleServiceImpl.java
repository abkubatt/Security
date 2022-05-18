package com.example.security.services.Impl;

import com.example.security.dao.RoleDao;
import com.example.security.mappers.RoleMapper;
import com.example.security.models.dtos.RoleDto;
import com.example.security.models.entities.Role;
import com.example.security.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    private RoleMapper roleMapper = RoleMapper.INSTANCE;

    @Override
    public RoleDto save(RoleDto roleDto) {
        Role role = roleMapper.toEntity(roleDto);
        return roleMapper.toDto(roleDao.save(role));
    }
}
