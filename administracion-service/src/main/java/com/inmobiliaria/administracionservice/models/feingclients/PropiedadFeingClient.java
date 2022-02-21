package com.inmobiliaria.administracionservice.models.feingclients;

import com.inmobiliaria.administracionservice.models.entity.Propiedad;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "propiedad-service", url = "http://localhost:8003")
public interface PropiedadFeingClient {
    @PostMapping("/propiedad")
    public Propiedad save(@RequestBody Propiedad propiedad);
    @DeleteMapping("/propiedad/{id}")
    public Propiedad delete(@PathVariable Long id);
}
