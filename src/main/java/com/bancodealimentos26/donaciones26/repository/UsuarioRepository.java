package com.bancodealimentos26.donaciones26.repository;

import com.bancodealimentos26.donaciones26.model.Usuario;


import org.springframework.data.jpa.repository.JpaRepository;


// Esta interfaz extiende JpaRepository, lo que le proporciona métodos CRUD básicos para la entidad Usuario.
//  Además, se define un método personalizado findByEmail para buscar usuarios por su correo electrónico.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}