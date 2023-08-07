package com.example.SpringDataJPA.repositories;

import com.example.SpringDataJPA.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositories extends JpaRepository<Address, Integer> {
}
