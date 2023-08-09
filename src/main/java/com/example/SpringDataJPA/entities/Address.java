package com.example.SpringDataJPA.entities;

import lombok.*;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@NotNull
    private int flatNo;

    //@NotNull
    //@Size(min = 2, max = 10)
    private String buildingName;

    //@NotNull
    //@Size(min = 2, max = 10)
    private String streetName;

    private String city;

    //@NotNull
    private int pinCode;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;
}
