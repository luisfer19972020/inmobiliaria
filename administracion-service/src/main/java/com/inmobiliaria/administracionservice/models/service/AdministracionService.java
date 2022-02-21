package com.inmobiliaria.administracionservice.models.service;

import java.util.List;

import com.inmobiliaria.administracionservice.models.entity.Propiedad;
import com.inmobiliaria.administracionservice.models.feingclients.PropiedadFeingClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdministracionService implements IAdministracionService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private PropiedadFeingClient propiedadFeingClient;

    @Override
    @SuppressWarnings("all")
    public List<Propiedad> getPropiedades() {
        return restTemplate.getForObject("http://propiedad-service/propiedad", List.class);
    }

    @Override
    public Propiedad getPropiedadById(Long id) {
        return restTemplate.getForObject("http://propiedad-service/propiedad/"+id, Propiedad.class);
    }

    @Override
    public Propiedad savePropiedad(Propiedad propiedad) {
        return propiedadFeingClient.save(propiedad);
    }

    @Override
    public Propiedad deletePropiedad(Long id) {
        return propiedadFeingClient.delete(id);
    }

   
}
