package com.inmobiliaria.reclamoservice.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "reclamos")
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descripcion;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "usuario_id")
    private int usuarioId;

    @Column(name = "propiedad_id")
    private int propiedadId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPropiedadId() {
        return this.propiedadId;
    }

    public void setPropiedadId(int propiedadId) {
        this.propiedadId = propiedadId;
    }       
}