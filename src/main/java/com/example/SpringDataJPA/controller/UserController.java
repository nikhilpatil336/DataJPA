package com.example.SpringDataJPA.controller;

import com.example.SpringDataJPA.entities.User;
import com.example.SpringDataJPA.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello world";
    }
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> createUser(@Valid @RequestBody User userRequest)
    {
        User userResponse = userService.createUser(userRequest);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getuserById(@PathVariable int id)
    {
        User userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "pageNumber", defaultValue = "1", required = false
    ) int pageNumber, @RequestParam(value = "pageSize", defaultValue = "1", required = false) int pageSize) {
        List<User> userResponses = userService.getAllUsers(pageNumber-1, pageSize);
        return ResponseEntity.ok(userResponses);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUserByName(@RequestParam String firstName) {
        return ResponseEntity.ok(userService.deleteUser(firstName));
    }

    @GetMapping("/name/{firstName}")
    public ResponseEntity<List<User>> getuserByName(@RequestParam String firstName)
    {
        List<User>  userResponse = userService.getUserbyName(firstName);
        return ResponseEntity.ok(userResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @Valid @RequestBody User userRequest)
    {
        userService.updateUser(id, userRequest);
        return ResponseEntity.ok("User updated");
    }
}