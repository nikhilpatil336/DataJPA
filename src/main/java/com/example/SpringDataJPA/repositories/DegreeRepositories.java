package com.example.SpringDataJPA.repositories;

import com.example.SpringDataJPA.entities.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepositories extends JpaRepository<Degree, Integer> {
}
