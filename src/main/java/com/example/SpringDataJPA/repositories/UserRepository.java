package com.example.SpringDataJPA.repositories;

import com.example.SpringDataJPA.entities.Address;
import com.example.SpringDataJPA.entities.Degree;
import com.example.SpringDataJPA.entities.Office;
import com.example.SpringDataJPA.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("DELETE FROM User u WHERE u.firstName = :firstName")
    @Modifying
    @Transactional
    void deleteUserByName(String firstName);


    @Modifying
    @Query("update User u SET u.firstName= :firstName, u.lastName = :lastName, u.address = :adderss, u.degree = :degrees, u.offices = :offices, u.age = :age, u.salary = :salary")
    void updateUser(String firstName, String lastName, Address adderss, List<Degree> degrees, List<Office> offices, int age, double salary);

    @Query("Select u from User u where u.firstName = :firstName")
    List<User> findUserName(String firstName);
}
