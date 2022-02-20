package com.inmobiliaria.citaservice.repository;

import com.inmobiliaria.citaservice.entity.Cita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository <Cita, Integer> {
    
}
