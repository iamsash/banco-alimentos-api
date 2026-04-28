package com.bancodealimentos26.donaciones26.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Categoria {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
private LocalDate fechaRegistro = LocalDate.now();


public Categoria() {
}

public Categoria(String nombre, String descripcion) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.fechaRegistro = LocalDate.now();}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
