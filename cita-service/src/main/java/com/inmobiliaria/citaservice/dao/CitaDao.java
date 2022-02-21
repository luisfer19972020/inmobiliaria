package com.inmobiliaria.citaservice.dao;

import com.inmobiliaria.citaservice.entity.Cita;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaDao extends JpaRepository <Cita, Long> {
    
}
