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
        Role role = roleMapper.toRole(roleDto);
        Role savedRole = roleDao.save(role);
        return roleMapper.toRoleDto(savedRole);
    }

    @Override
    public RoleDto findById(Long id) {
        Role role = roleDao.findById(id).orElse(null);
        return roleMapper.toRoleDto(role);
    }

    @Override
    public RoleDto update(RoleDto roleDto) {
        boolean isExists = roleDao.existsById(roleDto.getId());
        if (!isExists){
            return null;
        }
        else{
            Role role =  roleMapper.toRole(roleDto);
            Role updatedRole = roleDao.save(role);
            return roleMapper.toRoleDto(updatedRole);
        }
    }

    @Override
    public boolean delete(RoleDto roleDto) {
        Role role = roleMapper.toRole(roleDto);
        roleDao.delete(role);
        return true;
    }
}
