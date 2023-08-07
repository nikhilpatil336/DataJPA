package com.example.SpringDataJPA.service.serviceImpl;

import com.example.SpringDataJPA.entities.User;
import com.example.SpringDataJPA.exception.ResourceNotFoundException;
import com.example.SpringDataJPA.repositories.UserRepository;
import com.example.SpringDataJPA.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    @Transactional
    public String deleteUser(String firstName) {
        userRepository.deleteUserByName(firstName);
            return "User deleted successfully";
    }

    @Override
    public void updateUser(int id, User userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setUserId(userRequest.getUserId());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setDegree(userRequest.getDegree());
        user.setAddress(userRequest.getAddress());
        user.setOffices(userRequest.getOffices());
        user.setAge(userRequest.getAge());
        user.setSalary(userRequest.getSalary());

        userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers(int pageNumber, int pageSize) {

        Pageable p = PageRequest.of(pageNumber, pageSize);

        Page<User> pageUser = userRepository.findAll(p);

        List<User> temp = pageUser.getContent();
        return temp;
    }

    @Override
    public List<User> getUserbyName(String firstName) {
        return userRepository.findUserName(firstName);
    }
}
