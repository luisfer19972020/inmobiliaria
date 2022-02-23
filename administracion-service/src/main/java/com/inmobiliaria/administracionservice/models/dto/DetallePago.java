package com.inmobiliaria.administracionservice.models.dto;

import java.io.Serializable;

import com.inmobiliaria.administracionservice.models.entity.Pago;
import com.inmobiliaria.administracionservice.models.entity.Propiedad;
import com.inmobiliaria.administracionservice.models.entity.Usuario;

public class DetallePago implements Serializable {
    private static final long serialVersionUID = 1L;
    private Pago pago;
    private Propiedad propiedad;
    private Usuario usuario;


    public Pago getPago() {
        return this.pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Propiedad getPropiedad() {
        return this.propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
