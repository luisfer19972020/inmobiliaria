package com.inmobiliaria.pagoservice.controller;

import java.util.List;

import com.inmobiliaria.pagoservice.entity.Pago;
import com.inmobiliaria.pagoservice.service.PagoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pago")
public class PagoController {
    
    @Autowired
    PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> getAll() {
        List<Pago> pagos = pagoService.getAll();
        if(pagos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(pagos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getById(@PathVariable("id") int id) {
        Pago pago = pagoService.getPagoById(id);
        if(pago == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pago);
    }

    @PostMapping()
    public ResponseEntity<Pago> save(@RequestBody Pago pago) {
        Pago pagoNew = pagoService.save(pago);
        return ResponseEntity.ok(pagoNew);
    }
}