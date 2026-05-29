package com.bancodealimentos26.donaciones26.dto;

public class DistribucionDTO {

    private Long id;
    private Double cantidad;
    private String fecha;

    private Long beneficiarioId;
    private String beneficiarioNombre;

    private Long alimentoId;
    private String alimentoNombre;

    public DistribucionDTO() {
    }

    public DistribucionDTO(Long id, Double cantidad, String fecha,
                           Long beneficiarioId, String beneficiarioNombre,
                           Long alimentoId, String alimentoNombre) {
        this.id = id;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.beneficiarioId = beneficiarioId;
        this.beneficiarioNombre = beneficiarioNombre;
        this.alimentoId = alimentoId;
        this.alimentoNombre = alimentoNombre;
    }

    public Long getId() {
        return id;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public Long getBeneficiarioId() {
        return beneficiarioId;
    }

    public String getBeneficiarioNombre() {
        return beneficiarioNombre;
    }

    public Long getAlimentoId() {
        return alimentoId;
    }

    public String getAlimentoNombre() {
        return alimentoNombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setBeneficiarioId(Long beneficiarioId) {
        this.beneficiarioId = beneficiarioId;
    }

    public void setBeneficiarioNombre(String beneficiarioNombre) {
        this.beneficiarioNombre = beneficiarioNombre;
    }

    public void setAlimentoId(Long alimentoId) {
        this.alimentoId = alimentoId;
    }

    public void setAlimentoNombre(String alimentoNombre) {
        this.alimentoNombre = alimentoNombre;
    }
}