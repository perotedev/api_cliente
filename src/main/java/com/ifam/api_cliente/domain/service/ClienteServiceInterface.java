package com.ifam.api_cliente.domain.service;

import java.util.List;
import com.ifam.api_cliente.domain.entity.Cliente;

public interface ClienteServiceInterface {
    List<Cliente> getClientes();
    Cliente getClienteById(Long id);
    Cliente saveCliente(Cliente cliente);
    void updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);
}
