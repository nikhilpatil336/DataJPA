package com.example.SpringDataJPA.service.serviceImpl;

import com.example.SpringDataJPA.RequestDTO.*;
import com.example.SpringDataJPA.entities.*;
import com.example.SpringDataJPA.exception.ResourceNotFoundException;
import com.example.SpringDataJPA.repositories.*;
import com.example.SpringDataJPA.service.AddressService;
import com.example.SpringDataJPA.service.DegreeService;
import com.example.SpringDataJPA.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private ModelMapper mapper;

    private UserRepository userRepository;

    private DegreeRepositories degreeRepositories;

    private AddressRepositories addressRepositories;

    private OfficeRepositories officeRepositories;

    private DegreeService degreeService;

    private AddressService addressService;

    @Override
    public User createUser(CollectionDTO collectionDTO)
    {
        User user = mapper.map(collectionDTO.getUserRequestDTO(), User.class);

        //Address address = mapper.map(collectionDTO.getAddressRequestDTO(), Address.class);

        Address address = addressService.createAddress(collectionDTO.getAddressRequestDTO(), user);
        //user.setAddress(address);

        List<Office> offices = collectionDTO.getOfficeRequestDTO().stream()
                .map(x -> mapper.map(x, Office.class)).collect(Collectors.toList());
        user.setOffices(offices);

        User savedUser = userRepository.save(user);

        //addressService.createAddress(collectionDTO.getAddressRequestDTO(), savedUser);

        List<Degree> degrees = collectionDTO.getDegreeRequestDTOS().stream().map(x -> degreeService.createDegree(x, savedUser)).collect(Collectors.toList());

        //savedUser.setAddress(address);
        return savedUser;
    }

//    @Override
//    @Transactional
//    public String deleteUser(String firstName) {
//        userRepository.deleteUserByName(firstName);
//            return "User deleted successfully";
//    }

    public void deleteUser(int id)
    {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User do not exist"));
        List<Degree> degrees = degreeRepositories.findByUser(user);
        degrees.stream().forEach(x -> degreeRepositories.deleteById(x.getId()));
        userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user do not exist"));
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(int id, UserRequestDTO userRequest) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        //user.setDegrees(userRequest.getDegrees());
        //user.setAddress(userRequest.getAddress());
        //user.setOffices(userRequest.getOffices());
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

        Pageable p = PageRequest.of(pageNumber-1, pageSize);

        Page<User> pageUser = userRepository.findAll(p);

        List<User> temp = pageUser.getContent();
        return temp;
    }

    @Override
    public List<User> getUserbyName(String firstName) {
        return userRepository.findUserName(firstName);
    }
}
