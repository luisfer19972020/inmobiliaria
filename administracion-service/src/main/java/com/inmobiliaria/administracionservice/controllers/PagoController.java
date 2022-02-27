package com.inmobiliaria.administracionservice.controllers;

import com.inmobiliaria.administracionservice.models.service.IAdministracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("admin/pagos")
public class PagoController {

    @Autowired
    private IAdministracionService administracionService;

    @GetMapping("/alquiler")
    public String alquileres(Model model) {
        model.addAttribute("pagos", administracionService.getPagosAlquiler());
        return "admin/pagos/index";
    }

    @GetMapping("/alquiler/{id}")
    public String verAlquiler(Model model, @PathVariable Long id) {
        model.addAttribute("detalle", administracionService.getPagoById(id));
        return "admin/pagos/details";
    }

    @GetMapping("/compra")
    public String compras(Model model) {
        model.addAttribute("pagos", administracionService.getPagosCompra());
        return "admin/pagos/index";
    }

    @PutMapping("/aprobar/{id}")
    public String aprobar(@PathVariable Long id,@RequestParam(name = "tipo", required = false) Integer tipo, RedirectAttributes flash) {
        administracionService.aprobarPagoById(id);
        flash.addFlashAttribute("success", "Pago aceptado con exito!!!");
        return "redirect:/admin/pagos/"+(tipo==1?"compra":"alquiler");
    }
    
    @DeleteMapping("/rechazar/{id}")
    public String rechazar(@PathVariable Long id,@RequestParam(name = "tipo", required = false) Integer tipo, RedirectAttributes flash) {
        administracionService.rechazarPagoById(id);
        flash.addFlashAttribute("success", "Pago rechazado con exito!!!");
        return "redirect:/admin/pagos/"+(tipo==1?"compra":"alquiler");
    }

}
