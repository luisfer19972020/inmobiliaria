package com.inmobiliaria.reclamoservice.controller;

import java.util.List;

import com.inmobiliaria.reclamoservice.entity.Reclamo;
import com.inmobiliaria.reclamoservice.repository.ReclamoRepository;
import com.inmobiliaria.reclamoservice.service.ReclamoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reclamo")
public class ReclamoController {
    
    @Autowired
    ReclamoService reclamoService;

    @Autowired
    ReclamoRepository reclamoRepository;

    @GetMapping
    public ResponseEntity<List<Reclamo>> getAll() {
        List<Reclamo> reclamos = reclamoService.getAll();
        if(reclamos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reclamo> getById(@PathVariable("id") int id) {
        Reclamo reclamo = reclamoService.getReclamoById(id);
        if(reclamo == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(reclamo);
    }   

    @PostMapping()
    public ResponseEntity<Reclamo> save(@RequestBody Reclamo reclamo) {
        Reclamo reclamoNew = reclamoService.save(reclamo);
        return ResponseEntity.ok(reclamoNew);
    }

    // DELETE
    @DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		reclamoRepository.deleteById(id);
	}
}