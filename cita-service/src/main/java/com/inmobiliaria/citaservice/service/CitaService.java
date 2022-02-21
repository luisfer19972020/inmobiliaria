/* package com.inmobiliaria.citaservice.service;

import java.util.List;

import com.inmobiliaria.citaservice.dao.CitaDao;
import com.inmobiliaria.citaservice.entity.Cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
    
    @Autowired
    CitaDao citaRepository;

    public List<Cita> getAll() {
        return citaRepository.findAll();
    }

    public Cita getCitaById(int id) {
        return citaRepository.findById(id).orElse(null);
    }

    public Cita save(Cita cita) {
        Cita citaNew = citaRepository.save(cita);
        return citaNew;
    } */

    // FALTA DELETE
    /* public void deleteById(Integer id) {
        citaRepository.deleteById(id);
    } */
    /* public Cita deleteById(int id) {
        return citaRepository.deleteById(id);
    } 
}
*/