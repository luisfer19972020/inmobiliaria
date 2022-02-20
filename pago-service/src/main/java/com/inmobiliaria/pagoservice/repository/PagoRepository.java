package com.inmobiliaria.pagoservice.repository;

import com.inmobiliaria.pagoservice.entity.Pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository <Pago, Integer> {
    
}
