package com.ifam.api_cliente.config;

import com.ifam.api_cliente.dto.ResponseDto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoConfig {

    @Bean
    public ResponseDto responseDto() {
        return new ResponseDto();
    }
}