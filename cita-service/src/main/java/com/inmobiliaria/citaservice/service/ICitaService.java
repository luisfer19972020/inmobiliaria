package com.inmobiliaria.citaservice.service;

import java.util.List;
import java.util.Optional;

import com.inmobiliaria.citaservice.entity.Cita;

public interface ICitaService {

    public List<Cita> getAll();

    public Cita getCitaById(Long id);

    public Cita save(Cita cita);

    public Cita deleteById(Long id);

    Optional<Cita> findById(Long id);
}
