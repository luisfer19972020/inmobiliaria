package com.inmobiliaria.reclamoservice.dao;

import com.inmobiliaria.reclamoservice.entity.Reclamo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamoDao extends JpaRepository <Reclamo, Long> {
    
}
