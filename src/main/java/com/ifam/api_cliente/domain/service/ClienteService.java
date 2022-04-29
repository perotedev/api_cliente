package com.ifam.api_cliente.domain.service;

import java.util.ArrayList;
import java.util.List;

import com.ifam.api_cliente.domain.entity.Cliente;
import com.ifam.api_cliente.domain.repository.ClienteRepository;

import org.springframework.stereotype.Service;

@Service
public class ClienteService implements ClienteServiceInterface {
    ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        this.clienteRepository.findAll().forEach(clientes::add);
        return clientes;
    }

    @Override
    public Cliente getClienteById(Long id) {
        return this.clienteRepository.findById(id).get();
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente clienteFound = this.clienteRepository.findById(id).get();
        if (!this.clienteRepository.findById(id).isEmpty()){
            clienteFound.setNome(cliente.getNome());
            clienteFound.setCpf(cliente.getCpf());
            clienteFound.setSexo(cliente.getSexo());
            clienteFound.setData_nascimento(cliente.getData_nascimento());
            this.clienteRepository.save(clienteFound);
        }
        return clienteFound;
    }

    @Override
    public void deleteCliente(Long id) {
        this.clienteRepository.deleteById(id);        
    }
    
}
