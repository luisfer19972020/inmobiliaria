package com.inmobiliaria.pagoservice.models.dao;

import com.inmobiliaria.pagoservice.models.entity.Pago;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPagoDao extends JpaRepository<Pago,Long> {
    
}
