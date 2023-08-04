package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.entities.User;
import com.example.SpringDataJPA.responseDTO.UserResponseDTO;

import java.util.List;

public interface UserService {

    User createUser(User userRequest);

    String deleteUser(String firstName);

    User updateUser(int id, User userRequest);

    User getUserById(int id);

    List<User> getAllUsers();
}
