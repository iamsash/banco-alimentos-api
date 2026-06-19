package com.bancodealimentos26.donaciones26.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String nombre;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToOne
@JoinColumn(name = "rol_id")
private Rol rol;

    public Admin() {
    }

    public Admin(String nombre, String email, String password, Rol rol) {
    this.nombre = nombre;
    this.email = email;
    this.password = password;
    this.rol = rol;
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
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
    return rol;
}

public void setRol(Rol rol) {
    this.rol = rol;
}
}
