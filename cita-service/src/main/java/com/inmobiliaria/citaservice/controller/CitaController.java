package com.inmobiliaria.citaservice.controller;

import java.util.List;
import java.util.Optional;

import com.inmobiliaria.citaservice.entity.Cita;
import com.inmobiliaria.citaservice.service.ICitaService;

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
@RequestMapping("/cita")
public class CitaController {
    
    @Autowired
    ICitaService citaService;

    // READ
    @GetMapping
    public ResponseEntity<List<Cita>> getAll() {
        List<Cita> citas = citaService.getAll();
        if(citas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(citas);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Cita> getById(@PathVariable("id") Long id) {
        Cita cita = citaService.getCitaById(id);
        if(cita == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cita);
    }

    // CREATE
    @PostMapping()
    public ResponseEntity<Cita> save(@RequestBody Cita cita) {
        Cita citaNew = citaService.save(cita);
        return ResponseEntity.ok(citaNew);
    }

    // UPDATE
    @PutMapping()
    public ResponseEntity<Cita> update(@RequestBody Cita cita) {
        Cita citaNew = citaService.save(cita);
        return ResponseEntity.ok(citaNew);
    } 

    /*
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Cita> update(@RequestBody Cita cita, @PathVariable Long id) {
        Optional<Cita> citaOpt = citaService.findById(id);

        if (!citaOpt.isPresent())
            return ResponseEntity.notFound().build();

        cita.setId(id);
        citaService.save(cita);

        return ResponseEntity.noContent().build();
        //Cita citaNew = citaService.save(cita);
        //return ResponseEntity.ok(citaNew);
    } 
    */
    

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Cita> deleteById(@PathVariable Long id) {
        Cita citaNew = citaService.deleteById(id);
        return ResponseEntity.ok(citaNew);
    }

    /* 
    @DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		citaService.deleteById(id);
	} 
    */
}
