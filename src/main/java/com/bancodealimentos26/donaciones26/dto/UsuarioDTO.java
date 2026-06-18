package com.bancodealimentos26.donaciones26.dto;

import com.bancodealimentos26.donaciones26.model.Rol;
import java.time.LocalDate;


public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private Rol rol;
    private LocalDate fechaRegistro;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nombre, String email, String telefono,Rol rol, LocalDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.rol = rol;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRol() {return rol;}

    public void setRol(Rol rol) {this.rol = rol;}

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}