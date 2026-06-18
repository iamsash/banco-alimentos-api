package com.bancodealimentos26.donaciones26.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public class DonacionDTO {

    private Long id;

    @NotNull(message = "La cantidad es obligatoria")
    @Positive(message = "La cantidad debe ser mayor a cero")
    private Double cantidad;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;
    private String usuarioNombre;

    @NotNull(message = "El ID del alimento es obligatorio")
    private Long alimentoId;
    private String alimentoNombre;

    public DonacionDTO() {
    }

    public DonacionDTO(Long id, Double cantidad, LocalDate fecha,
                       Long usuarioId, String usuarioNombre,
                       Long alimentoId, String alimentoNombre) {
        this.id = id;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.alimentoId = alimentoId;
        this.alimentoNombre = alimentoNombre;
    }

    public Long getId() { return id; }
    public Double getCantidad() { return cantidad; }
    public LocalDate getFecha() { return fecha; }
    public Long getUsuarioId() { return usuarioId; }
    public String getUsuarioNombre() { return usuarioNombre; }
    public Long getAlimentoId() { return alimentoId; }
    public String getAlimentoNombre() { return alimentoNombre; }

    public void setId(Long id) { this.id = id; }
    public void setCantidad(Double cantidad) { this.cantidad = cantidad; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }
    public void setAlimentoId(Long alimentoId) { this.alimentoId = alimentoId; }
    public void setAlimentoNombre(String alimentoNombre) { this.alimentoNombre = alimentoNombre; }
}