package com.bancodealimentos26.donaciones26.dto;

public class InventarioDTO {

    private Long alimentoId;
    private String alimentoNombre;
    private String categoriaNombre;
    private String unidadMedida;
    private Double totalDonado;
    private Double totalDistribuido;
    private Double stockActual;

    public InventarioDTO() {
    }

    public InventarioDTO(Long alimentoId, String alimentoNombre, String categoriaNombre,
                         String unidadMedida, Double totalDonado,
                         Double totalDistribuido, Double stockActual) {
        this.alimentoId = alimentoId;
        this.alimentoNombre = alimentoNombre;
        this.categoriaNombre = categoriaNombre;
        this.unidadMedida = unidadMedida;
        this.totalDonado = totalDonado;
        this.totalDistribuido = totalDistribuido;
        this.stockActual = stockActual;
    }

    public Long getAlimentoId() {
        return alimentoId;
    }

    public void setAlimentoId(Long alimentoId) {
        this.alimentoId = alimentoId;
    }

    public String getAlimentoNombre() {
        return alimentoNombre;
    }

    public void setAlimentoNombre(String alimentoNombre) {
        this.alimentoNombre = alimentoNombre;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getTotalDonado() {
        return totalDonado;
    }

    public void setTotalDonado(Double totalDonado) {
        this.totalDonado = totalDonado;
    }

    public Double getTotalDistribuido() {
        return totalDistribuido;
    }

    public void setTotalDistribuido(Double totalDistribuido) {
        this.totalDistribuido = totalDistribuido;
    }

    public Double getStockActual() {
        return stockActual;
    }

    public void setStockActual(Double stockActual) {
        this.stockActual = stockActual;
    }
}
