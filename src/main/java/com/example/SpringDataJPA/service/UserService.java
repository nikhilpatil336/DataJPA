package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User userRequest);

    String deleteUser(String firstName);

    void updateUser(int id, User userRequest);

    User getUserById(int id);

    List<User> getAllUsers();

    List<User> getUserbyName(String firstName);
}
