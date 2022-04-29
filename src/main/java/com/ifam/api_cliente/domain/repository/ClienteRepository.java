package com.ifam.api_cliente.domain.repository;

import com.ifam.api_cliente.domain.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
