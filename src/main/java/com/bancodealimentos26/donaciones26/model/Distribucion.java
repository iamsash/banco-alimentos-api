package com.bancodealimentos26.donaciones26.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Distribucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Double cantidad;
    private LocalDate fecha;
    
    @ManyToOne
@JoinColumn(name = "beneficiario_id")
private Beneficiario beneficiario;

    @ManyToOne
    @JoinColumn (name = "alimento_id")
    private Alimento alimento;
    

    public Long getId() {
        return id;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Alimento getAlimento() {
        return alimento;
    }
    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }
}