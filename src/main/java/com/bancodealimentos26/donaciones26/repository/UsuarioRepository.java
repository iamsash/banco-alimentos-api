package com.bancodealimentos26.donaciones26.repository;

import com.bancodealimentos26.donaciones26.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}