package com.inmobiliaria.administracionservice.models.service;

import java.util.List;
import com.inmobiliaria.administracionservice.models.dao.IUserDao;
import com.inmobiliaria.administracionservice.models.dto.DetallePago;
import com.inmobiliaria.administracionservice.models.entity.Pago;
import com.inmobiliaria.administracionservice.models.entity.Propiedad;
import com.inmobiliaria.administracionservice.models.feingclients.PagoFeingClient;
import com.inmobiliaria.administracionservice.models.feingclients.PropiedadFeingClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdministracionService implements IAdministracionService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private PropiedadFeingClient propiedadFeingClient;

    @Autowired
    private PagoFeingClient pagoFeingClient;

    @Override
    @SuppressWarnings("all")
    public List<Propiedad> getPropiedades() {
        return restTemplate.getForObject("http://propiedad-service/propiedad", List.class);
    }

    @Override
    public Propiedad getPropiedadById(Long id) {
        return restTemplate.getForObject("http://propiedad-service/propiedad/" + id, Propiedad.class);
    }

    @Override
    public Propiedad savePropiedad(Propiedad propiedad) {
        return propiedadFeingClient.save(propiedad);
    }

    @Override
    public Propiedad deletePropiedad(Long id) {
        return propiedadFeingClient.delete(id);
    }

    @Override
    @SuppressWarnings("all")
    public List<Pago> getPagosAlquiler() {
        return restTemplate.getForObject("http://pago-service/pago/getByType/2", List.class);
    }

    @Override
    @SuppressWarnings("all")
    public List<Pago> getPagosCompra() {
        return restTemplate.getForObject("http://pago-service/pago/getByType/1", List.class);
    }

    @Override
    public DetallePago getPagoById(Long id) {
        DetallePago detalle = new DetallePago();
        Pago pago = restTemplate.getForObject("http://pago-service/pago/" + id, Pago.class);
        detalle.setPago(pago);
        detalle.setUsuario(userDao.findById(pago.getUserId()).orElse(null));
        detalle.setPropiedad(this.getPropiedadById(pago.getPropiedadId()));
        return detalle;
    }

    @Override
    public Pago aprobarPagoById(Long id) {
        Pago pago = restTemplate.getForObject("http://pago-service/pago/" + id, Pago.class);
        pago.setEstatus(true);
        return pagoFeingClient.save(pago);
    }

    @Override
    public Pago rechazarPagoById(Long id) {
        return pagoFeingClient.delete(id);
    }

}
