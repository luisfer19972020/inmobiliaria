package com.inmobiliaria.propiedadservice.controllers;

import java.util.List;

import com.inmobiliaria.propiedadservice.models.entity.Propiedad;
import com.inmobiliaria.propiedadservice.models.service.IPropiedadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propiedad")
public class PropiedadController {
    @Autowired
    private IPropiedadService propiedadService;

    @GetMapping
    public ResponseEntity<List<Propiedad>> getAll() {
        List<Propiedad> propiedades = propiedadService.getAll();
        if (propiedades.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(propiedades);
    }
  
    @GetMapping("/{id}")
    public ResponseEntity<Propiedad> getById(@PathVariable Long id) {
        Propiedad propiedad = propiedadService.getPropiedadById(id);
        if (propiedad==null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(propiedad);
    }
    
    @PostMapping()
    public ResponseEntity<Propiedad> save(@RequestBody Propiedad propiedad) {
        Propiedad propiedadNew = propiedadService.save(propiedad);
        return ResponseEntity.ok(propiedadNew);
    }
   
    @PutMapping()
    public ResponseEntity<Propiedad> update(@RequestBody Propiedad propiedad) {
        Propiedad propiedadNew = propiedadService.save(propiedad);
        return ResponseEntity.ok(propiedadNew);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Propiedad> deleteById(@PathVariable Long id) {
        Propiedad propiedadNew = propiedadService.deleteById(id);
        return ResponseEntity.ok(propiedadNew);
    }
}
