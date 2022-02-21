package com.inmobiliaria.clienteservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    @Column(name = "reclamo_id")
    private Date reclamoId;

    @Column(name = "cita_id")
    private int citaId;
    
    @Column(name = "pago_id")
    private int pagoId;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getReclamoId() {
        return this.reclamoId;
    }

    public void setReclamoId(Date reclamoId) {
        this.reclamoId = reclamoId;
    }

    public int getCitaId() {
        return this.citaId;
    }

    public void setCitaId(int citaId) {
        this.citaId = citaId;
    }

    public int getPagoId() {
        return this.pagoId;
    }

    public void setPagoId(int pagoId) {
        this.pagoId = pagoId;
    }
}
