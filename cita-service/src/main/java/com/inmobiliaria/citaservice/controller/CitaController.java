package com.inmobiliaria.citaservice.controller;

import java.util.List;

import com.inmobiliaria.citaservice.entity.Cita;
import com.inmobiliaria.citaservice.repository.CitaRepository;
import com.inmobiliaria.citaservice.service.CitaService;

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
    CitaService citaService;

    @Autowired
    CitaRepository citaRepository;

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
    public ResponseEntity<Cita> getById(@PathVariable("id") int id) {
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
	public void update(@RequestBody Cita cita){
		citaRepository.save(cita);
	}

    // DELETE
    @DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		citaRepository.deleteById(id);
	}
}
