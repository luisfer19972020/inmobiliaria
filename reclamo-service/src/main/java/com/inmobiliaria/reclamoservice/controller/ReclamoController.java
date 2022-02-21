package com.inmobiliaria.reclamoservice.controller;

import java.util.List;
// import java.util.Optional;

import com.inmobiliaria.reclamoservice.entity.Reclamo;
// import com.inmobiliaria.reclamoservice.repository.ReclamoRepository;
import com.inmobiliaria.reclamoservice.service.IReclamoService;

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
@RequestMapping("/reclamo")
public class ReclamoController {
    
    @Autowired
    IReclamoService reclamoService;

    // READ
    @GetMapping
    public ResponseEntity<List<Reclamo>> getAll() {
        List<Reclamo> reclamos = reclamoService.getAll();
        if(reclamos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(reclamos);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Reclamo> getById(@PathVariable("id") Long id) {
        Reclamo reclamo = reclamoService.getReclamoById(id);
        if(reclamo == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(reclamo);
    }   

    // CREATE
    @PostMapping()
    public ResponseEntity<Reclamo> save(@RequestBody Reclamo reclamo) {
        Reclamo reclamoNew = reclamoService.save(reclamo);
        return ResponseEntity.ok(reclamoNew);
    }

    // UPDATE
    @PutMapping()
    public ResponseEntity<Reclamo> update(@RequestBody Reclamo reclamo) {
        Reclamo reclamoNew = reclamoService.save(reclamo);
        return ResponseEntity.ok(reclamoNew);
    }

    /* 
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Reclamo> update(@RequestBody Reclamo reclamo, @PathVariable int id) {
        Optional<Reclamo> reclamoOpt = reclamoRepository.findById(id);

        if (!reclamoOpt.isPresent())
            return ResponseEntity.notFound().build();

        reclamo.setId(id);
        reclamoService.save(reclamo);

        return ResponseEntity.noContent().build();
    }
    */

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Reclamo> deleteById(@PathVariable Long id) {
        Reclamo reclamoNew = reclamoService.deleteById(id);
        return ResponseEntity.ok(reclamoNew);
    }
    
    /* 
    @DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		reclamoService.deleteById(id);
	} 
    */
}