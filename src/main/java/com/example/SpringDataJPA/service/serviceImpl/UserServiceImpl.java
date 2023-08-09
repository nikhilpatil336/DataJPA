package com.example.SpringDataJPA.service.serviceImpl;

import com.example.SpringDataJPA.RequestDTO.*;
import com.example.SpringDataJPA.entities.*;
import com.example.SpringDataJPA.exception.ResourceNotFoundException;
import com.example.SpringDataJPA.repositories.*;
import com.example.SpringDataJPA.service.UserService;
//import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private ModelMapper mapper;

    private UserRepository userRepository;

    private UserDegreeRepository userDegreeRepository;

    private DegreeRepositories degreeRepositories;

    private AddressRepositories addressRepositories;

    private OfficeRepositories officeRepositories;

    @Override
    public User createUser(CollectionDTO collectionDTO)
    {

        User user = mapper.map(collectionDTO.getUserRequestDTO(), User.class);

        Address address = mapper.map(collectionDTO.getAddressRequestDTO(), Address.class);
        user.setAddress(address);


        List<Office> offices = collectionDTO.getOfficeRequestDTO().stream()
                .map(x -> mapper.map(x, Office.class)).collect(Collectors.toList());
        user.setOffices(offices);

        return userRepository.save(user);

//        //List<Office> savedOffice = officeRepositories.saveAll(offices);
//
//        user.setOffices(offices);
//
//        log.info("office details :: {}", offices.toString());
//
//        List<Degree> degrees = collectionDTO.getDegreeRequestDTO().stream()
//                .map(x-> mapper.map(x, Degree.class)).collect(Collectors.toList());
//
//        List<Degree> savedDegree = degreeRepositories.saveAll(degrees);
//
//        //log.info("degree details :: {}", savedDegree);
//
////        List<UserDegree> userDegrees = collectionDTO.getUserDegreeRequestDTOS().stream()
////                .map(x-> mapper.map(x, UserDegree.class)).collect(Collectors.toList());
//
//        List<UserDegree> userDegrees = new ArrayList<>();
//
//        int size = collectionDTO.getDegreeRequestDTO().size();
//
//        for(int i = 0; i < size; i++) {
////            userDegrees.get(i).setUser(user);
////            userDegrees.get(i).setDegree(degrees.get(i));
//
//            UserDegree userDegree = UserDegree
//                    .builder()
//                    .user(user)
//                    .degree(degrees.get(i))
//                    .build();
//            userDegree.setUser(user);
//            userDegree.setDegree(savedDegree.get(i));
//            userDegrees.add(userDegree);
//        }
//
//        log.info("userDegree details :: {}", userDegrees.toString());
//
//        //List<UserDegree> savedUserDegree = userDegreeRepository.saveAll(userDegrees);
//
//        user.setUserDegrees(userDegrees);
//
//        return userRepository.save(user);
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
//        user.setUserDegrees(userRequest.getUserDegrees());
//        user.setAddress(userRequest.getAddress());
//        user.setOffices(userRequest.getOffices());
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
