package com.inmobiliaria.administracionservice.models.service;

import java.util.List;

import com.inmobiliaria.administracionservice.models.dto.DetallePago;
import com.inmobiliaria.administracionservice.models.entity.Pago;
import com.inmobiliaria.administracionservice.models.entity.Propiedad;

public interface IAdministracionService {
    public List<Propiedad> getPropiedades();
    public Propiedad getPropiedadById(Long id);
    public Propiedad savePropiedad(Propiedad propiedad);
    public Propiedad deletePropiedad(Long id);
    public List<Pago> getPagosAlquiler();
    public List<Pago> getPagosCompra();
    public DetallePago getPagoById(Long id);
    public Pago aprobarPagoById(Long id);
    public Pago rechazarPagoById(Long id);
}
