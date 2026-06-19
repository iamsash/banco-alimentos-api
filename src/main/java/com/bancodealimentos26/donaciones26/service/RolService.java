package com.bancodealimentos26.donaciones26.service;

import com.bancodealimentos26.donaciones26.model.Rol;
import com.bancodealimentos26.donaciones26.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerPorId(Long id) {
        return rolRepository.findById(id);
    }

    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol actualizarRol(Long id, Rol rolActualizado) {

        return rolRepository.findById(id).map(rol -> {

            rol.setNombre(rolActualizado.getNombre());
            rol.setDescripcion(rolActualizado.getDescripcion());

            return rolRepository.save(rol);

        }).orElse(null);

    }

    public boolean eliminarRol(Long id) {

        if (rolRepository.existsById(id)) {

            rolRepository.deleteById(id);

            return true;

        }

        return false;

    }

}