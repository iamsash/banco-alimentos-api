package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.dto.UsuarioDTO;
import com.bancodealimentos26.donaciones26.model.Usuario;
import com.bancodealimentos26.donaciones26.service.UsuarioService;
import com.bancodealimentos26.donaciones26.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// Importaciones estáticas para HATEOAS (Nivel 3 de Richardson)
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UsuarioDTO>> obtenerPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario con ID: " + id));

        UsuarioDTO dto = convertirADto(usuario);

        EntityModel<UsuarioDTO> recurso = EntityModel.of(dto);

        WebMvcLinkBuilder linkToSelf = linkTo(methodOn(this.getClass()).obtenerPorId(id));
        recurso.add(linkToSelf.withSelfRel());

        WebMvcLinkBuilder linkToAll = linkTo(methodOn(this.getClass()).listarTodos());
        recurso.add(linkToAll.withRel("todos-los-usuarios"));

        return ResponseEntity.ok(recurso);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
        List<UsuarioDTO> listaDTO = usuarioService.listarUsuarios().stream()                    .map(this::convertirADto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(convertirADto(nuevoUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    private UsuarioDTO convertirADto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setTelefono(usuario.getTelefono());
        dto.setDni(usuario.getDni());
        dto.setDireccion(usuario.getDireccion());

        dto.setTipoUsuario(usuario.getTipoUsuario());
        dto.setActivo(usuario.getActivo());

        return dto;
    }
}