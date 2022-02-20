package com.inmobiliaria.pagoservice.service;

import java.util.List;

import com.inmobiliaria.pagoservice.entity.Pago;
import com.inmobiliaria.pagoservice.repository.PagoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;

    public List<Pago> getAll() {
        return pagoRepository.findAll();
    }

    public Pago getPagoById(int id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public Pago save(Pago pago) {
        Pago pagoNew = pagoRepository.save(pago);
        return pagoNew;
    }
}