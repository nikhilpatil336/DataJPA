package com.example.SpringDataJPA.entities;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private int userId;

    //@NotNull
    //@Size(min = 2, max = 10)
    @Column(name = "firstName", nullable = false)
    private String firstName;

    //@NotNull
    //@Size(min = 2, max = 10)
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    //@NotNull
    private Address address;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
//    //@Column(name = "degree")
//    private List<UserDegree> userDegrees;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_office",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "officeId")
    )
    @Column(name = "office")
    private List<Office> offices;

    @Column(name = "age")
    private int age;

    //@NotNull
    @Column(name = "salary", nullable = false)
    private double salary;
}