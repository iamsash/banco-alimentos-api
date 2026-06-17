package com.bancodealimentos26.donaciones26.dto;

import java.time.LocalDate;

public class CategoriaDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaRegistro;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id, String nombre, String descripcion, LocalDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}