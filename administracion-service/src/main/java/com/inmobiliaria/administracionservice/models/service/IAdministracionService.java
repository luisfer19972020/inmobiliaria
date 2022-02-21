package com.inmobiliaria.administracionservice.models.service;

import java.util.List;

import com.inmobiliaria.administracionservice.models.entity.Propiedad;

public interface IAdministracionService {
    public List<Propiedad> getPropiedades();
    public Propiedad getPropiedadById(Long id);
    public Propiedad savePropiedad(Propiedad propiedad);
    public Propiedad deletePropiedad(Long id);
}
