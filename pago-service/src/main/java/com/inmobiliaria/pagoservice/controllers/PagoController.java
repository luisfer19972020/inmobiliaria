package com.inmobiliaria.pagoservice.controllers;

import java.util.List;

import com.inmobiliaria.pagoservice.models.entity.Pago;
import com.inmobiliaria.pagoservice.models.service.IPagoService;

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
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private IPagoService pagoService;

    @GetMapping()
    public ResponseEntity<List<Pago>> getAll() {
        List<Pago> pagos = pagoService.getAll();
        return pagos.isEmpty() ? ResponseEntity.noContent().build(): ResponseEntity.ok(pagos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getById(@PathVariable Long id) {
        Pago pago = pagoService.getPagoById(id);
        return pagoService.getPagoById(id) == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(pago);
    }

    @PostMapping()
    public ResponseEntity<Pago> save(@RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.save(pago));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pago> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.deleteById(id));
    }
}
