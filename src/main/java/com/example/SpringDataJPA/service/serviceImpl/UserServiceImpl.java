package com.example.SpringDataJPA.service.serviceImpl;

import com.example.SpringDataJPA.entities.User;
import com.example.SpringDataJPA.repositories.UserRepository;
import com.example.SpringDataJPA.responseDTO.UserResponseDTO;
import com.example.SpringDataJPA.service.UserService;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User createUser(User userRequest) {
        User userResponse = userRepository.save(userRequest);
        return userResponse;
    }

    @Override
    public String deleteUser(String firstName) {
        userRepository.deleteUserByName(firstName);
        return "User deleted successfully";
    }

    @Override
    public User updateUser(int id, User userRequest) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
