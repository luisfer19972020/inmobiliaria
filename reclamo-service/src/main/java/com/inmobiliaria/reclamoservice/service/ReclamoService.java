/* package com.inmobiliaria.reclamoservice.service;

import java.util.List;

import com.inmobiliaria.reclamoservice.entity.Reclamo;
import com.inmobiliaria.reclamoservice.repository.ReclamoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamoService {

    @Autowired
    ReclamoRepository reclamoRepository;

    public List<Reclamo> getAll() {
        return reclamoRepository.findAll();
    }

    public Reclamo getReclamoById(int id) {
        return reclamoRepository.findById(id).orElse(null);
    }

    public Reclamo save(Reclamo reclamo) {
        Reclamo reclamoNew = reclamoRepository.save(reclamo);
        return reclamoNew;
    } */

    // FALTA DELETE
/*     public void deleteById(Integer id) {
        reclamoRepository.deleteById(id);
    }
} */
