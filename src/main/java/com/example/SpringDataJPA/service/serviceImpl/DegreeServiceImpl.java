package com.example.SpringDataJPA.service.serviceImpl;

import com.example.SpringDataJPA.RequestDTO.DegreeRequestDTO;
import com.example.SpringDataJPA.entities.Degree;
import com.example.SpringDataJPA.entities.User;
import com.example.SpringDataJPA.repositories.DegreeRepositories;
import com.example.SpringDataJPA.repositories.UserRepository;
import com.example.SpringDataJPA.service.DegreeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DegreeServiceImpl implements DegreeService {

    private DegreeRepositories degreeRepositories;
    private UserRepository userRepository;
    private ModelMapper mapper;

    @Override
    public Degree createDegree(DegreeRequestDTO degreeRequestDTO, User savedUser) {

        log.info("Inside create degree service");
        System.out.println("degreeDTO: "+ degreeRequestDTO.getDegreeName());

        Degree degree = Degree.builder()
                .degreeName(degreeRequestDTO.getDegreeName())
                .user(savedUser)
                .build();

       return saveDegree(degree);

    }

    @Override
    public Degree createDegree(DegreeRequestDTO degreeRequestDTO) {

        log.info("Inside create degree service");
        System.out.println("degreeDTO: "+ degreeRequestDTO.getDegreeName());

        Degree degree = Degree.builder()
                .degreeName(degreeRequestDTO.getDegreeName())
                .build();

        return saveDegree(degree);

    }


    private Degree saveDegree(Degree degree){
        return degreeRepositories.save(degree);
    }

}
