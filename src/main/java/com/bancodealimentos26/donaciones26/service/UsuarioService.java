package com.bancodealimentos26.donaciones26.service;

import com.bancodealimentos26.donaciones26.dto.UsuarioDTO;
import java.util.stream.Collectors;
import com.bancodealimentos26.donaciones26.model.Usuario;
import com.bancodealimentos26.donaciones26.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarUsuarios() {

    return usuarioRepository.findAll()
            .stream()
            .map(usuario -> new UsuarioDTO(
                    usuario.getId(),
                    usuario.getNombre(),
                    usuario.getEmail(),
                    usuario.getTelefono(),
                    usuario.getRol(),
                    usuario.getFechaRegistro()
            ))
            .collect(Collectors.toList());
}
    public List<UsuarioDTO> listarTrabajadores() {

        return usuarioRepository.findByRol(com.bancodealimentos26.donaciones26.model.Rol.TRABAJADOR)
                .stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getEmail(),
                        usuario.getTelefono(),
                        usuario.getRol(),
                        usuario.getFechaRegistro()
                ))
                .collect(Collectors.toList());
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
    return usuarioRepository.findById(id).map(usuario -> {
        usuario.setNombre(usuarioActualizado.getNombre());
        usuario.setEmail(usuarioActualizado.getEmail());
        usuario.setTelefono(usuarioActualizado.getTelefono());
        usuario.setRol(usuarioActualizado.getRol());

        return usuarioRepository.save(usuario);
    }).orElse(null);
}}