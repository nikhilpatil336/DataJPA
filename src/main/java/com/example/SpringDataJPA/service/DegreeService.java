package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.RequestDTO.DegreeRequestDTO;
import com.example.SpringDataJPA.entities.Degree;

public interface DegreeService {

    Degree createDegree(DegreeRequestDTO degreeRequestDTO);
}
