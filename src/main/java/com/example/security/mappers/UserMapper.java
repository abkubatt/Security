package com.example.security.mappers;

import com.example.security.models.dtos.UserDto;
import com.example.security.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

    List<User> toUserList(List<UserDto> userDtos);

    List<UserDto> toUserDtoList(List<User> users);
}
