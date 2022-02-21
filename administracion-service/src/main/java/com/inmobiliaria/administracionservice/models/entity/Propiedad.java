package com.inmobiliaria.administracionservice.models.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Propiedad {
    private Long id;
    private Boolean ocupada;
    @NotBlank
    private String descripcion;
    private String foto;
    @NotNull
    private Integer habitaciones;
    @NotNull
    private Float m2;
    private Double costoCompra;
    private Double costoAlquiler;
    @NotNull
    private Integer tipo;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isOcupada() {
        return this.ocupada;
    }

    public Boolean getOcupada() {
        return this.ocupada;
    }

    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getHabitaciones() {
        return this.habitaciones;
    }

    public void setHabitaciones(Integer habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Float getM2() {
        return this.m2;
    }

    public void setM2(Float m2) {
        this.m2 = m2;
    }

    public Double getCostoCompra() {
        return this.costoCompra;
    }

    public void setCostoCompra(Double costoCompra) {
        this.costoCompra = costoCompra;
    }

    public Double getCostoAlquiler() {
        return this.costoAlquiler;
    }

    public void setCostoAlquiler(Double costoAlquiler) {
        this.costoAlquiler = costoAlquiler;
    }

    public Integer getTipo() {
        return this.tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

}
