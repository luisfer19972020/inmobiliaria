package com.inmobiliaria.administracionservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class HomeController {
    @GetMapping(value={"/",""})
    public String getMethodName() {
        return "admin/home";
    }
    
}
