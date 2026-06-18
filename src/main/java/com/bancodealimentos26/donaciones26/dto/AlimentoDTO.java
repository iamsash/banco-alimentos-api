package com.bancodealimentos26.donaciones26.dto;

import com.bancodealimentos26.donaciones26.model.Categoria;
import java.time.LocalDate;

public class AlimentoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String unidadMedida;
    private LocalDate fechaRegistro;

   private Categoria categoria;

    public AlimentoDTO() {
    }

    public AlimentoDTO(Long id, String nombre, String descripcion,
                       String unidadMedida, LocalDate fechaRegistro,
                       Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.fechaRegistro = fechaRegistro;
        this.categoria = categoria;
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

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
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

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
    
