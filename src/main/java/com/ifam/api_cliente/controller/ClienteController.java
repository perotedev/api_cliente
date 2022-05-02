package com.ifam.api_cliente.controller;

import java.util.List;
import javax.validation.Valid;
import com.ifam.api_cliente.domain.entity.Cliente;
import com.ifam.api_cliente.domain.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes = this.clienteService.getClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Cliente> getClienteById(@Valid @PathVariable Long id){
        return new ResponseEntity<Cliente>(this.clienteService.getClienteById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@Valid @RequestBody Cliente cliente){
        this.clienteService.saveCliente(cliente);
        return new ResponseEntity<Cliente>(this.clienteService.getClienteById(cliente.getId()), HttpStatus.CREATED);
    } 

    @PutMapping("{id}")
    public ResponseEntity<Cliente> updateCliente(@Valid @PathVariable Long id, @RequestBody Cliente cliente){
        this.clienteService.updateCliente(id, cliente);
        return new ResponseEntity<Cliente>(this.clienteService.getClienteById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@Valid @PathVariable Long id){
        this.clienteService.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
