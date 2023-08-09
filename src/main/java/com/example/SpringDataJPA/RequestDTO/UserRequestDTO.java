package com.example.SpringDataJPA.RequestDTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRequestDTO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "userId")
    //private int userId;

    //@NotNull
    //@Size(min = 2, max = 10)
    private String firstName;

    //@NotNull
    //@Size(min = 2, max = 10)
    private String lastName;

//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
//    @NotNull
//    private Address address;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
//    //@Column(name = "degree")
//    private List<UserDegree> userDegrees;
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "user_office",
//            joinColumns = @JoinColumn(name = "userId"),
//            inverseJoinColumns = @JoinColumn(name = "officeId")
//    )
//    @Column(name = "office")
//    //@LazyCollection(LazyCollectionOption.FALSE)
//    //@Size(min=1, message="You must choose at least 1 ingredient")
//    private List<Office> offices;

    private int age;

    //@NotNull
    private double salary;

}
