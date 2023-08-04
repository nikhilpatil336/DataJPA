package com.example.SpringDataJPA.controller;

import com.example.SpringDataJPA.entities.User;
import com.example.SpringDataJPA.responseDTO.UserResponseDTO;
import com.example.SpringDataJPA.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

//    @GetMapping("/hello")
//    public String hello()
//    {
//        return "Hello world";
//    }

    @Autowired
    private UserService userService;

    public ResponseEntity<User> createUser(@Valid @RequestBody User userRequest)
    {
        User userResponse = userService.createUser(userRequest);
        return ResponseEntity.ok(userResponse);
    }

    public ResponseEntity<User> getuserById(@PathVariable int id)
    {
        User userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userResponses = userService.getAllUsers();
        return ResponseEntity.ok(userResponses);
    }

    public ResponseEntity<String> deleteUserByName(@RequestParam String firstName) {
        return ResponseEntity.ok(userService.deleteUser(firstName));
    }
}