package com.inmobiliaria.propiedadservice.models.dao;

import com.inmobiliaria.propiedadservice.models.entity.Propiedad;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PropiedadDao extends JpaRepository<Propiedad,Long> {
    
}
