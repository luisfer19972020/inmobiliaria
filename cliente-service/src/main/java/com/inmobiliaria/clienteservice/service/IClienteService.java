package com.inmobiliaria.clienteservice.service;

import java.util.List;

import com.inmobiliaria.clienteservice.entity.Cliente;

public interface IClienteService {
    public List<Cliente> getAll();

    public Cliente getClienteById(Long id);

    public Cliente save(Cliente cliente);

    public Cliente deleteById(Long id);
}
