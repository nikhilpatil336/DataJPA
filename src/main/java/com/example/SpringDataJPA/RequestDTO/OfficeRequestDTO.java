package com.example.SpringDataJPA.RequestDTO;

import com.example.SpringDataJPA.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OfficeRequestDTO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "officeId")
   // private int id;

    //@NotNull
    //@Size(min = 2, max = 10)
    private String name;
}
