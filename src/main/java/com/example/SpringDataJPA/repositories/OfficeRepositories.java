package com.example.SpringDataJPA.repositories;

import com.example.SpringDataJPA.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfficeRepositories extends JpaRepository<Office, Integer> {

    //public List<Office> findAllByUserId(int id);

//    @Query("SELECT o FROM Office o WHERE o.user.id = :id")
//    public List<Office> findAllByIdIn(int id);
}
