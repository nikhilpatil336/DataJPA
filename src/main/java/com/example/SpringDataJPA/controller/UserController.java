package com.example.SpringDataJPA.controller;

import com.example.SpringDataJPA.RequestDTO.*;
import com.example.SpringDataJPA.entities.Address;
import com.example.SpringDataJPA.entities.User;
import com.example.SpringDataJPA.repositories.AddressRepositories;
import com.example.SpringDataJPA.responseDTO.UserResponseDTO;
import com.example.SpringDataJPA.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private UserService userService;

    private ModelMapper mapper;
    
    private AddressRepositories addressRepositories;

    @PostMapping()
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody CollectionDTO collectionDTO)
    {
        User userResponse = userService.createUser(collectionDTO);

        UserResponseDTO userResponseDTO = mapper.map(userResponse, UserResponseDTO.class);

        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getuserById(@PathVariable int id)
    {
        User savedUser = userService.getUserById(id);
        UserResponseDTO userResponseDTO = mapper.map(savedUser, UserResponseDTO.class);
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(@RequestParam(value = "pageNumber", defaultValue = "1", required = false
    ) int pageNumber, @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        List<User> userResponses = userService.getAllUsers(pageNumber, pageSize);
        List<UserResponseDTO> userResponseDTOS = userResponses.stream().map(x -> mapper.map(x, UserResponseDTO.class)).collect(Collectors.toList());

        return ResponseEntity.ok(userResponseDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        userService.deleteUser(id);

        return ResponseEntity.ok("data got deleted");
    }

//    @GetMapping("/name/{firstName}")
//    public ResponseEntity<List<User>> getuserByName(@RequestParam String firstName)
//    {
//        List<User>  userResponse = userService.getUserbyName(firstName);
//        return ResponseEntity.ok(userResponse);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @Valid @RequestBody UserRequestDTO userRequest)
    {
        userService.updateUser(id, userRequest);
        return ResponseEntity.ok("User updated");
    }
}