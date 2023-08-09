package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.RequestDTO.DegreeRequestDTO;
import com.example.SpringDataJPA.entities.Degree;
import com.example.SpringDataJPA.entities.User;

public interface DegreeService {

    Degree createDegree(DegreeRequestDTO degreeRequestDTO, User savedUser);
    Degree createDegree(DegreeRequestDTO degreeRequestDTO);
}

