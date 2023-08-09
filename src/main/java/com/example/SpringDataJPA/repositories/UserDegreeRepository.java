package com.example.SpringDataJPA.repositories;

import com.example.SpringDataJPA.entities.UserDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDegreeRepository extends JpaRepository<UserDegree, Integer> {
}
