package com.example.SpringDataJPA.mapper;

import com.example.SpringDataJPA.entities.User;
import com.example.SpringDataJPA.responseDTO.UserResponseDTO;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;
//import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
public interface UserResponseUserMapper {

    //UserResponseUserMapper userMap= Mappers.getMapper(UserResponseUserMapper.class);

    public UserResponseDTO modelToDto(User user);

    public User dtoToModel(UserResponseDTO userRequest);
}
