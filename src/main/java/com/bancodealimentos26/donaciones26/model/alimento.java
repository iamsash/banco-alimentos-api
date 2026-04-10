package com.bancodealimentos26.donaciones26.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alimentos")
public class alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    // Constructor vacío (OBLIGATORIO)
    public alimento() {
    }

    // Constructor con parámetros
    public alimento(String nombre, String descripcion, String unidadMedida, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}