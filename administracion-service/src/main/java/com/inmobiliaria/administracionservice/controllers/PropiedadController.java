package com.inmobiliaria.administracionservice.controllers;

import java.io.IOException;

import javax.validation.Valid;

import com.inmobiliaria.administracionservice.models.entity.Propiedad;
import com.inmobiliaria.administracionservice.models.service.IAdministracionService;
import com.inmobiliaria.administracionservice.models.service.IUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("admin/propiedades")
@SessionAttributes("propiedad")
public class PropiedadController {
    @Autowired
    private IAdministracionService administracionService;
    @Autowired
    private IUploadService uploadService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("propiedades", administracionService.getPropiedades());
        return "admin/propiedades/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Propiedad propiedad = new Propiedad();
        model.addAttribute("propiedad", propiedad);
        return "admin/propiedades/create";
    }

    @PostMapping("/store")
    public String store(@Valid Propiedad propiedad, BindingResult result, RedirectAttributes flash, Model model,
            SessionStatus status, @RequestParam(name = "file") MultipartFile foto) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Veririfca los campos al llenar el formulario!!");
            return "admin/propiedades/create";
        }
        if (foto.isEmpty()) {
            model.addAttribute("error", "Agrega una foto para la propiedad!!");
            return "admin/propiedades/create";
        }
        // Proceso para guardar la foto
        String nombreArchivo = null;
        try {// Intenta guardar el archivo del request
            nombreArchivo = uploadService.guardar(foto);
            flash.addFlashAttribute("info", "Imagen cargada correctamente".concat(nombreArchivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        propiedad.setFoto(nombreArchivo);

        administracionService.savePropiedad(propiedad);
        status.setComplete();
        flash.addFlashAttribute("success", "Propiedad creada con exito!!!");
        return "redirect:/admin/propiedades";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable Long id, RedirectAttributes flash, Model model) {
        Propiedad propiedad = null;
        if (id > 0) {
            propiedad = administracionService.getPropiedadById(id);
            if (propiedad == null) {
                flash.addFlashAttribute("warning", "El ID: " + id + " No existe en la base de datos!!");
                return "redirect:/admin/propiedades";
            }
        } else {
            flash.addFlashAttribute("error", "El ID no puede ser cero");
            return "redirect:/admin/propiedades";
        }
        model.addAttribute("propiedad", propiedad);
        return "admin/propiedades/details";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
        Propiedad propiedad = null;
        if (id > 0) {
            propiedad = administracionService.getPropiedadById(id);
            if (propiedad == null) {
                flash.addFlashAttribute("warning", "El ID: " + id + " No existe en la base de datos!!");
                return "redirect:/admin/propiedaes";
            }
        } else {
            flash.addFlashAttribute("error", "El ID no puede ser cero");
            return "redirect:/admin/propiedaes";
        }
        model.addAttribute("propiedad", propiedad);
        return "admin/propiedades/edit";
    }

    @PutMapping("/update")
    public String update(@Valid Propiedad propiedad, BindingResult result, RedirectAttributes flash, Model model,
            SessionStatus status, @RequestParam(name = "file") MultipartFile foto) {
        if (result.hasErrors()) {
            model.addAttribute("Error", "Veririfca los campos al llenar el formulario!!");
            return "admin/propiedades/edit";
        }

        if (!foto.isEmpty()) {// Si viene una imagen

            if (uploadService.eliminar(propiedad.getFoto())) {
                flash.addFlashAttribute("info", "La foto del propiedad, "
                        + propiedad.getFoto() + " ha sido actualizada");
            } else {
                flash.addFlashAttribute("error", "La foto del propiedad, "
                        + propiedad.getFoto() + " no se pudo eliminar");
            }
            String nombreArchivo = null;
            try {
                nombreArchivo = uploadService.guardar(foto);
                flash.addFlashAttribute("info", "Imagen cargada correctamente".concat(nombreArchivo));
            } catch (IOException e) {
                e.printStackTrace();
            }
            propiedad.setFoto(nombreArchivo);
        }

        administracionService.savePropiedad(propiedad);
        status.setComplete();
        flash.addFlashAttribute("success", "Propiedad editada con exito!!!");
        return "redirect:/admin/propiedades";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes flash) {
        if (id > 0) {
            Propiedad propiedad = administracionService.deletePropiedad(id);
            flash.addFlashAttribute("success", "Propiedad eliminada con exito!!!");

            if (uploadService.eliminar(propiedad.getFoto())) {// Elimnamos el archivo
                flash.addFlashAttribute("info", "La foto del propiedad, "
                        + propiedad.getFoto() + " ha sido eliminada");
            } else {
                flash.addFlashAttribute("error", "La foto del propiedad, "
                        + propiedad.getFoto() + " no se pudo eliminar");
            }
        }
        return "redirect:/admin/propiedades";
    }

}
