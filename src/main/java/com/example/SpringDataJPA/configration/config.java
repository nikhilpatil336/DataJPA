package com.example.SpringDataJPA.configration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {

    @Bean
    public ModelMapper createMapper()
    {
        return new ModelMapper();
    }

}
