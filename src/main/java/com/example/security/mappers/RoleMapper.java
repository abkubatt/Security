package com.example.security.mappers;

import com.example.security.models.dtos.RoleDto;
import com.example.security.models.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleDto>{
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);


}
