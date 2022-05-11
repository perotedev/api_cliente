package com.ifam.api_cliente.repository;

import com.ifam.api_cliente.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
