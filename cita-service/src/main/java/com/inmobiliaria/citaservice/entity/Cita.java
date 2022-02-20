package com.inmobiliaria.citaservice.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "citas")
public class Cita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;

    @Column(name = "fecha_cita")
    private Date fechaCita;

    @Column(name = "propiedad_id")
    private int propiedadId;
    
    @Column(name = "usuario_id")
    private int usuarioId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFechaCita() {
        return this.fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public int getPropiedadId() {
        return this.propiedadId;
    }

    public void setPropiedadId(int propiedadId) {
        this.propiedadId = propiedadId;
    }

    public int getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}