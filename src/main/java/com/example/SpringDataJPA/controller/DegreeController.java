package com.example.SpringDataJPA.controller;

import com.example.SpringDataJPA.RequestDTO.CollectionDTO;
import com.example.SpringDataJPA.RequestDTO.DegreeRequestDTO;
import com.example.SpringDataJPA.entities.Degree;
import com.example.SpringDataJPA.service.DegreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/degrees")
@Slf4j
public class DegreeController {

    @Autowired
    private DegreeService degreeService;

    @PostMapping
    public ResponseEntity<Degree> createDegree (@RequestBody DegreeRequestDTO degreeRequestDTO)
    {
        log.info("Inside create degree controller");
        System.out.println("degreerequestdto is "+degreeRequestDTO.getDegreeName());
        //log.info("controller degreeDTO: ", degreeRequestDTO.t;
        return ResponseEntity.ok(degreeService.createDegree(degreeRequestDTO));
    }
}
