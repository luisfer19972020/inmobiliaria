package com.inmobiliaria.clienteservice.controller;

import java.util.List;

import com.inmobiliaria.clienteservice.entity.Cliente;
import com.inmobiliaria.clienteservice.service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    IClienteService clienteService;

    // READ
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clienteService.getAll();
        if(clientes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(clientes);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        if(cliente == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cliente);
    }

    // CREATE
    @PostMapping()
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        Cliente clienteNew = clienteService.save(cliente);
        return ResponseEntity.ok(clienteNew);
    }

    // UPDATE
    @PutMapping()
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        Cliente clienteNew = clienteService.save(cliente);
        return ResponseEntity.ok(clienteNew);
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteById(@PathVariable Long id) {
        Cliente clienteNew = clienteService.deleteById(id);
        return ResponseEntity.ok(clienteNew);
    }
}