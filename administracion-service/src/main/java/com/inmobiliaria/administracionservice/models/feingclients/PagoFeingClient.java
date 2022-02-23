package com.inmobiliaria.administracionservice.models.feingclients;

import com.inmobiliaria.administracionservice.models.entity.Pago;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pago-service")
public interface PagoFeingClient {
    @PostMapping("/pago")
    public Pago save(@RequestBody Pago pago);
    @DeleteMapping("/pago/{id}")
    public Pago delete(@PathVariable Long id);
}
