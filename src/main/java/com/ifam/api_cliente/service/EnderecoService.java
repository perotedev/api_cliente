package com.ifam.api_cliente.service;

import com.ifam.api_cliente.dto.ResponseDto;
import com.ifam.api_cliente.entity.Endereco;
import com.ifam.api_cliente.repository.EnderecoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnderecoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    EnderecoRepository enderecoRepository;

    public ResponseDto saveEndereco(Endereco endereco) {
        responseDto.setId(enderecoRepository.save(endereco).getId());
        return responseDto;
    }

}