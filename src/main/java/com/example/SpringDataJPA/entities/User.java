package com.example.SpringDataJPA.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @NotNull
    @Size(min = 2, max = 10)
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 10)
    @Column(name = "lastName")
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NotNull
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(name = "degree")
    private List<Degree> degree;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(name = "offices")
    private List<Office> offices;

    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "salary")
    private double salary;
}
