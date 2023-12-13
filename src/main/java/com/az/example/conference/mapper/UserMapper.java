package com.az.example.conference.mapper;

import com.az.example.conference.dao.entity.UserEntity;
import com.az.example.conference.model.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto entityToDto(UserEntity userEntity);

}
