package com.inmobiliaria.propiedadservice.models.service;

import java.util.List;

import com.inmobiliaria.propiedadservice.models.dao.PropiedadDao;
import com.inmobiliaria.propiedadservice.models.entity.Propiedad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class PropiedadServiceImp implements IPropiedadService {
    @Autowired
    private PropiedadDao propiedadDao;

    @Override
    @Transactional(readOnly = true)
    public List<Propiedad> getAll() {
        return propiedadDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Propiedad getPropiedadById(Long id) {
        return propiedadDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Propiedad save(Propiedad propiedad) {
        return propiedadDao.save(propiedad);
    }

    @Override
    @Transactional
    public Propiedad deleteById(Long id) {
        Propiedad propiedad = propiedadDao.findById(id).orElse(null);
        propiedadDao.deleteById(id);
        return propiedad;
    }
}
