package com.example.SpringDataJPA.entities;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "userss")
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    @NotNull
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @Column(name = "degree")
    private List<Degree> degree;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "users")
//    @JoinTable(
//            name = "user_office",
//            joinColumns = @JoinColumn(name = "office_id"),
//            inverseJoinColumns = @JoinColumn(name = "userId")
//    )
//   @Column(name = "office")
//    private List<Office> office;

    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "salary")
    private double salary;
}