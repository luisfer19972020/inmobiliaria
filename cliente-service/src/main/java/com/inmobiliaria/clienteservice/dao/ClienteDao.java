package com.inmobiliaria.clienteservice.dao;

import com.inmobiliaria.clienteservice.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository <Cliente, Long> {
    
}
