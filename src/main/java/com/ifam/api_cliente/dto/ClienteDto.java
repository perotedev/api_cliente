package com.ifam.api_cliente.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    Long id;
    String nome;
    Date nascimento;
    String sexo;
    String cpf;  
}
