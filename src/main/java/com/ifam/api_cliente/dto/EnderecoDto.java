package com.ifam.api_cliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {
    Long id;
    String cep;
    String rua;
    String uf;
    String cidade;
    String bairro;
    int numero; 
}
