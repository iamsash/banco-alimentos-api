package com.bancodealimentos26.donaciones26.repository;

import com.bancodealimentos26.donaciones26.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.bancodealimentos26.donaciones26.model.Rol;



// Esta interfaz extiende JpaRepository, lo que le proporciona métodos CRUD básicos para la entidad Usuario.
//  Además, se define un método personalizado findByEmail para buscar usuarios por su correo electrónico.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    List<Usuario> findByRol(Rol rol);
}