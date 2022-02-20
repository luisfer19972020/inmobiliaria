package com.inmobiliaria.reclamoservice.repository;

import com.inmobiliaria.reclamoservice.entity.Reclamo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoRepository extends JpaRepository <Reclamo, Integer> {
    
}
