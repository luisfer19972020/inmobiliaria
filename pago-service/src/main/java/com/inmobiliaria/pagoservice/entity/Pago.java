package com.inmobiliaria.pagoservice.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private String status;
    private String tipo_pago;
    private Date fecha_pago;

    public Pago() {
    }

    public Pago(int id, String descripcion, String status, String tipo_pago, Date fecha_pago) {
        this.id = id;
        this.descripcion = descripcion;
        this.status = status;
        this.tipo_pago = tipo_pago;
        this.fecha_pago = fecha_pago;
    }

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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo_pago() {
        return this.tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public Date getFecha_pago() {
        return this.fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
}
