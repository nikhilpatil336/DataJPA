package com.example.SpringDataJPA.repositories;

import com.example.SpringDataJPA.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepositories extends JpaRepository<Office, Integer> {
}
