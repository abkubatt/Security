package com.example.security.mappers;

import com.example.security.models.dtos.RoleDto;
import com.example.security.models.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role toRole(RoleDto roleDto);

    RoleDto toRoleDto(Role role);

    List<Role> toRoleList(List<RoleDto> roleDtos);

    List<RoleDto> toRoleDtoList(List<Role> roles);
}
