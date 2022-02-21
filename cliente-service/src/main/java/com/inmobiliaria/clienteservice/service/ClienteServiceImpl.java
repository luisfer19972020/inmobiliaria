package com.inmobiliaria.clienteservice.service;

import java.util.List;

import com.inmobiliaria.clienteservice.dao.ClienteDao;
import com.inmobiliaria.clienteservice.entity.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getAll() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getClienteById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public Cliente deleteById(Long id) {
        Cliente cliente = clienteDao.findById(id).orElse(null);
        clienteDao.deleteById(id);
        return cliente;
    }
    
}
