package com.ifam.api_cliente.repository;

import com.ifam.api_cliente.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
