package com.inmobiliaria.reclamoservice.service;

import java.util.List;

import com.inmobiliaria.reclamoservice.entity.Reclamo;

public interface IReclamoService {
    
    public List<Reclamo> getAll();

    public Reclamo getReclamoById(Long id);

    public Reclamo save(Reclamo reclamo);

    public Reclamo deleteById(Long id);
}
