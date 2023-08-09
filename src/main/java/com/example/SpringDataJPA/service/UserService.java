package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.RequestDTO.*;
import com.example.SpringDataJPA.entities.User;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

    User createUser(CollectionDTO collectionDTO);

    String deleteUser(String firstName);

    void updateUser(int id, User userRequest);

    User getUserById(int id);

    List<User> getAllUsers(int pageNumber, int pageSize);

    List<User> getUserbyName(String firstName);
}
