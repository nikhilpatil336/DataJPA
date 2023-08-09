package com.example.SpringDataJPA.RequestDTO;

import com.example.SpringDataJPA.entities.Degree;
import com.example.SpringDataJPA.entities.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDegreeRequestDTO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne
//    @MapsId("userId")
//    @JoinColumn(name = "userId")
    //private User user;

//    @ManyToOne
//    @MapsId("degreeId")
//    @JoinColumn(name = "degreeId")
    //private Degree degree;

    private Date issueDate;

    private Date expiryDate;
}
