package com.bancodealimentos26.donaciones26.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donaciones")
public class donaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private usuario usuario;

    @ManyToOne
    @JoinColumn(name = "alimento_id", nullable = false)
    private alimento alimento;

    public donaciones() {
    }

    public donaciones(Integer cantidad, LocalDate fecha, usuario usuario, alimento alimento) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.usuario = usuario;
        this.alimento = alimento;
    }

    public Long getId() {
        return id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(alimento alimento) {
        this.alimento = alimento;
    }
}