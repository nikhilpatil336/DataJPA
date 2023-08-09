package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.RequestDTO.AddressRequestDTO;
import com.example.SpringDataJPA.RequestDTO.DegreeRequestDTO;
import com.example.SpringDataJPA.entities.Address;
import com.example.SpringDataJPA.entities.Degree;
import com.example.SpringDataJPA.entities.User;

public interface AddressService {

    Address createAddress(AddressRequestDTO addressRequestDTO, User savedUser);
}


