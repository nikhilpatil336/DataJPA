package com.example.SpringDataJPA.service.serviceImpl;

import com.example.SpringDataJPA.RequestDTO.AddressRequestDTO;
import com.example.SpringDataJPA.entities.Address;
import com.example.SpringDataJPA.entities.Degree;
import com.example.SpringDataJPA.entities.User;
import com.example.SpringDataJPA.repositories.AddressRepositories;
import com.example.SpringDataJPA.service.AddressService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

    private AddressRepositories addressRepositories;

    @Override
    public Address createAddress(AddressRequestDTO addressRequestDTO, User savedUser) {
        Address address = Address.builder()
                .flatNo(addressRequestDTO.getFlatNo())
                .buildingName(addressRequestDTO.getBuildingName())
                .city(addressRequestDTO.getCity())
                .pinCode(addressRequestDTO.getPinCode())
                .streetName(addressRequestDTO.getStreetName())
                .user(savedUser)
                .build();

        return addressRepositories.save(address);
    }
}
