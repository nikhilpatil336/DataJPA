package com.example.SpringDataJPA.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DegreeRequestDTO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int id;

    //@NotNull
//    @Size(max = 10)
    private String degreeName;

}
