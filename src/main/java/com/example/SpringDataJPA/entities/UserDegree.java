package com.example.SpringDataJPA.entities;

//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user_degree")
public class UserDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne
//    @MapsId("userId")
//    @JoinColumn(name = "userId")
//    private User user;
//
//    @ManyToOne
//    @MapsId("degreeId")
//    @JoinColumn(name = "degreeId")
//    private Degree degree;

    private Date issueDate;

    private Date expiryDate;
}
