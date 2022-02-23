package com.inmobiliaria.administracionservice.controllers;

import com.inmobiliaria.administracionservice.models.service.IAdministracionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@Secured("ROLE_SECRETARIA")
@RequestMapping("admin/pedidos")
public class PedidoController {

    @Autowired
    private IAdministracionService administracionService;

    @GetMapping()
    public String pedidos(Model model) {
        model.addAttribute("pedidos", administracionService.getPagosCompra());
        return "sec/pedidos/index";
    }
    
    @GetMapping("/{id}")
    public String detalles(@PathVariable Long id, Model model) {
        model.addAttribute("pedido", administracionService.getPagoById(id));
        return "sec/pedidos/details";
    }

}
