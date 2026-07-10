package com.bancodealimentos26.donaciones26.dto;

public class DashboardDTO {

    private long totalAlimentos;
    private long totalDonaciones;
    private long totalBeneficiarios;
    private long totalDistribuciones;
    private long totalCategorias;
    private long totalAdministradores;

    public DashboardDTO() {
    }

    public DashboardDTO(long totalAlimentos,
                        long totalDonaciones,
                        long totalBeneficiarios,
                        long totalDistribuciones,
                        long totalCategorias,
                        long totalAdministradores) {

        this.totalAlimentos = totalAlimentos;
        this.totalDonaciones = totalDonaciones;
        this.totalBeneficiarios = totalBeneficiarios;
        this.totalDistribuciones = totalDistribuciones;
        this.totalCategorias = totalCategorias;
        this.totalAdministradores = totalAdministradores;
    }

    public long getTotalAlimentos() {
        return totalAlimentos;
    }

    public void setTotalAlimentos(long totalAlimentos) {
        this.totalAlimentos = totalAlimentos;
    }

    public long getTotalDonaciones() {
        return totalDonaciones;
    }

    public void setTotalDonaciones(long totalDonaciones) {
        this.totalDonaciones = totalDonaciones;
    }

    public long getTotalBeneficiarios() {
        return totalBeneficiarios;
    }

    public void setTotalBeneficiarios(long totalBeneficiarios) {
        this.totalBeneficiarios = totalBeneficiarios;
    }

    public long getTotalDistribuciones() {
        return totalDistribuciones;
    }

    public void setTotalDistribuciones(long totalDistribuciones) {
        this.totalDistribuciones = totalDistribuciones;
    }

    public long getTotalCategorias() {
        return totalCategorias;
    }

    public void setTotalCategorias(long totalCategorias) {
        this.totalCategorias = totalCategorias;
    }

    public long getTotalAdministradores() {
        return totalAdministradores;
    }

    public void setTotalAdministradores(long totalAdministradores) {
        this.totalAdministradores = totalAdministradores;
    }
}