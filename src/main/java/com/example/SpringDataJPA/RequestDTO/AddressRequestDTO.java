package com.example.SpringDataJPA.RequestDTO;

import com.example.SpringDataJPA.entities.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddressRequestDTO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int id;

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

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "userId")
//    private User user;
}
