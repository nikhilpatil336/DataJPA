package com.example.SpringDataJPA.RequestDTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CollectionDTO {

    private UserRequestDTO userRequestDTO;

    private AddressRequestDTO addressRequestDTO;

    private List<OfficeRequestDTO> officeRequestDTO;
//
//    private List<DegreeRequestDTO> degreeRequestDTO;
}
