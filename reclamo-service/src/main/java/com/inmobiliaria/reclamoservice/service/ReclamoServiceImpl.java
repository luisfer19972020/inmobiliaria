package com.inmobiliaria.reclamoservice.service;

import java.util.List;

import com.inmobiliaria.reclamoservice.dao.ReclamoDao;
import com.inmobiliaria.reclamoservice.entity.Reclamo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReclamoServiceImpl implements IReclamoService {
    
    @Autowired
    private ReclamoDao reclamoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reclamo> getAll() {
        return reclamoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Reclamo getReclamoById(Long id) {
        return reclamoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Reclamo save(Reclamo reclamo) {
        return reclamoDao.save(reclamo);
    }

    @Override
    @Transactional
    public Reclamo deleteById(Long id) {
        Reclamo reclamo = reclamoDao.findById(id).orElse(null);
        reclamoDao.deleteById(id);
        return reclamo;
    }
}