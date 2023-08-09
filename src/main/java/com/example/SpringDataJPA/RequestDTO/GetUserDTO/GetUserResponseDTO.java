package com.example.SpringDataJPA.RequestDTO.GetUserDTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetUserResponseDTO {

    private String firstName;

    private String lastName;
}
