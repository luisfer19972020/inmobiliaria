package com.inmobiliaria.propiedadservice.models.service;

import java.util.List;

import com.inmobiliaria.propiedadservice.models.entity.Propiedad;

public interface IPropiedadService {
    public List<Propiedad> getAll();

    public Propiedad getPropiedadById(Long id);

    public Propiedad save(Propiedad propiedad);

    public Propiedad deleteById(Long id);
}
