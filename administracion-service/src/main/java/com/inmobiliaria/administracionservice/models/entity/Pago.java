package com.inmobiliaria.administracionservice.models.entity;

import java.io.Serializable;
import java.util.Date;

public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String descripcion;
    private Boolean estatus;
    private Integer tipoPago;
    private Date fechaPago;
    private Long userId;
    private Long propiedadId;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean isEstatus() {
        return this.estatus;
    }

    public Boolean getEstatus() {
        return this.estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    public Integer getTipoPago() {
        return this.tipoPago;
    }

    public void setTipoPago(Integer tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Date getFechaPago() {
        return this.fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPropiedadId() {
        return this.propiedadId;
    }

    public void setPropiedadId(Long propiedadId) {
        this.propiedadId = propiedadId;
    }

}
