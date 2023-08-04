package com.example.SpringDataJPA.responseDTO;


import com.example.SpringDataJPA.entities.Address;
import com.example.SpringDataJPA.entities.Degree;
import com.example.SpringDataJPA.entities.Office;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDTO {
    private int UserResponseDTOId;

    private String firstName;

    private String lastName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Degree> degree;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Office> office;

    private int age;

    private double salary;
}
