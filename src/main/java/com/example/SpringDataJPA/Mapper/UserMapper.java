package com.example.SpringDataJPA.Mapper;

import com.example.SpringDataJPA.entities.User;
import com.example.SpringDataJPA.responseDTO.UserResponseDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @InheritInverseConfiguration
    User userRequestToUser(User userRequest);

    @Mapping(source = "userId", target= "UserResponseDTOId")
    UserResponseDTO userToUserResponseDTO(User user);
}
