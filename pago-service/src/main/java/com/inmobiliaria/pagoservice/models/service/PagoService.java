package com.inmobiliaria.pagoservice.models.service;

import java.util.List;

import com.inmobiliaria.pagoservice.models.dao.IPagoDao;
import com.inmobiliaria.pagoservice.models.entity.Pago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PagoService implements IPagoService {

    @Autowired
    private IPagoDao pagoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pago> getAll() {
        return pagoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pago getPagoById(Long id) {
        return pagoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Pago save(Pago pago) {
        return pagoDao.save(pago);
    }

    @Override
    @Transactional
    public Pago deleteById(Long id) {
        Pago pago = pagoDao.findById(id).orElse(null);
        pagoDao.deleteById(id);
        return pago;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pago> getByTipoPago(Integer tipo) {
        return pagoDao.getByTipoPago(tipo);
    }

}
