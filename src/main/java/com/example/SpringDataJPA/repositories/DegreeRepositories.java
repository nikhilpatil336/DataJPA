package com.example.SpringDataJPA.repositories;

import com.example.SpringDataJPA.entities.Degree;
import com.example.SpringDataJPA.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DegreeRepositories extends JpaRepository<Degree, Integer> {

    List<Degree> findByUser(User user);
}