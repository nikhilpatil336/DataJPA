package com.example.SpringDataJPA.service.serviceImpl;

import com.example.SpringDataJPA.RequestDTO.DegreeRequestDTO;
import com.example.SpringDataJPA.entities.Degree;
import com.example.SpringDataJPA.entities.User;
import com.example.SpringDataJPA.repositories.DegreeRepositories;
import com.example.SpringDataJPA.service.DegreeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DegreeServiceImpl implements DegreeService {

    private DegreeRepositories degreeRepositories;
    private ModelMapper mapper;

    @Override
    public Degree createDegree(DegreeRequestDTO degreeRequestDTO) {

        log.info("Inside create degree service");
        System.out.println("degreeDTO: "+ degreeRequestDTO.getDegreeName());

        //Degree degree = mapper.map(degreeRequestDTO, Degree.class);
        Degree degree = Degree.builder().degreeName(degreeRequestDTO.getDegreeName()).build();
        System.out.println("degree: "+ degree.getDegreeName());

        Degree savedDegree = degreeRepositories.save(degree);

        return savedDegree;
    }
}
