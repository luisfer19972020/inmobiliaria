package com.inmobiliaria.propiedadservice.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "propiedades")
public class Propiedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ocupada;
    private String descripcion;
    private String foto;
    private Integer habitaciones;
    @Column(name = "m_2")
    private Float m2;
    @Column(name = "costo_compra", nullable = true)
    private Double costoCompra;
    @Column(name = "costo_alquiler", nullable = true)
    private Double costoAlquiler;
    private Integer tipo;

    @PrePersist
    public void prePersist(){
        if(getOcupada()==null){
            setOcupada(false);
        }
    }

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
