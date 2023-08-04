package com.example.SpringDataJPA.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

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

    @NotNull
    private int flatNo;

    @NotNull
    @Size(min = 2, max = 10)
    private String buildingName;

    @NotNull
    @Size(min = 2, max = 10)
    private String streetName;

    private String city;

    @NotNull
    private int pinCode;
}
