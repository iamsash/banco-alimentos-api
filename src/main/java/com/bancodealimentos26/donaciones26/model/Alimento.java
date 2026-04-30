package com.bancodealimentos26.donaciones26.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alimentos")
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    private String categoria;

    private String estado;

    public Alimento() {
        this.fechaRegistro = LocalDate.now();
        this.estado = "ACTIVO";
    }

    public Alimento(String nombre, String descripcion, String unidadMedida, String categoria, LocalDate fechaVencimiento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaRegistro = LocalDate.now();
        this.estado = "ACTIVO";
    }

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

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}