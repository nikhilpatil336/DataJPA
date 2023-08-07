package com.example.SpringDataJPA.entities;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Builder
@Entity
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id")
    private int id;
//
//    @NotNull
//    @Size(min = 2, max = 10)
//    private String name;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<User> users;
}

