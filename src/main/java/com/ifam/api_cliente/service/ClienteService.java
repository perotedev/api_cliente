package com.ifam.api_cliente.service;

import java.util.List;
import java.util.stream.Collectors;
import com.ifam.api_cliente.dto.ResponseDto;
import com.ifam.api_cliente.dto.ClienteDto;
import com.ifam.api_cliente.entity.Cliente;
import com.ifam.api_cliente.enumeration.Status;
import com.ifam.api_cliente.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    ClienteRepository clienteRepository;

    public ResponseDto saveCliente(Cliente cliente) {
        responseDto.setId(clienteRepository.save(cliente).getId());
        responseDto.setMenssage("Cliente incluído com sucesso...");
        responseDto.setStatus(Status.SUCCESS.value());
        return responseDto;
    }

    public List<ClienteDto> getAllCliente() {
        List<ClienteDto> listAllClienteDto = clienteRepository.findAll().stream()
                .map(Cliente -> modelMapper.map(Cliente, ClienteDto.class))
                .collect(Collectors.toList());
        return listAllClienteDto;
    }

    public List<ClienteDto> getAllClienteOrderByName() {
        List<ClienteDto> listAllClienteDto = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome")).stream()
                .map(Cliente -> modelMapper.map(Cliente, ClienteDto.class))
                .collect(Collectors.toList());
        return listAllClienteDto;
    }

    public ClienteDto getClienteById(Long id) {
        return modelMapper.map(clienteRepository.findById(id).get(), ClienteDto.class);
    }

    public ResponseDto updateCliente(Cliente cliente) {
        responseDto.setId(clienteRepository.save(cliente).getId());
        if (!clienteRepository.findById(cliente.getId()).isEmpty()) {
            clienteRepository.save(cliente);
            responseDto.setMenssage("Cliente alterado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Cliente inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

    public ResponseDto deleteCliente(Long id) {
        responseDto.setId(id);
        if (id > 0) {
            clienteRepository.deleteById(id);
            responseDto.setMenssage("Cliente deletado com sucesso...");
            responseDto.setStatus(Status.SUCCESS.value());
        } else {
            responseDto.setMenssage("ID do Cliente inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }
        return responseDto;
    }

}