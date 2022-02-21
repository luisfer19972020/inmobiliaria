package com.inmobiliaria.citaservice.service;

import java.util.List;
import java.util.Optional;

import com.inmobiliaria.citaservice.dao.CitaDao;
import com.inmobiliaria.citaservice.entity.Cita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    private CitaDao citaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> getAll() {
        return citaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cita getCitaById(Long id) {
        return citaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cita save(Cita cita) {
        return citaDao.save(cita);
    }

    @Override
    @Transactional
    public Cita deleteById(Long id) {
        Cita cita = citaDao.findById(id).orElse(null);
        citaDao.deleteById(id);
        return cita;
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Cita> findById(Long id) {
        return citaDao.findById(id);
    }
}