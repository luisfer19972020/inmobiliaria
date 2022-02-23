package com.inmobiliaria.pagoservice.models.service;

import java.util.List;

import com.inmobiliaria.pagoservice.models.entity.Pago;

public interface IPagoService {
    public List <Pago> getAll();

    public List <Pago> getByTipoPago(Integer tipo);

    public Pago getPagoById(Long id);

    public Pago save(Pago pago);

    public Pago deleteById(Long id);
}
