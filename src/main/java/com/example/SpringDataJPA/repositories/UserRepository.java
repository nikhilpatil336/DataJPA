package com.example.SpringDataJPA.repositories;

import com.example.SpringDataJPA.entities.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query("delete form user u where u.firstName = :firstName")
    void deleteUserByName(String firstName);

}
