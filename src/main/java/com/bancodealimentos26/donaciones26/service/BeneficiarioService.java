package com.bancodealimentos26.donaciones26.service;

import com.bancodealimentos26.donaciones26.dto.BeneficiarioDTO;
import com.bancodealimentos26.donaciones26.model.Beneficiario;
import com.bancodealimentos26.donaciones26.repository.BeneficiarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;

    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    // Listar (DTO)
    public List<BeneficiarioDTO> listar() {
        return beneficiarioRepository.findAll()
                .stream()
                .map(beneficiario -> new BeneficiarioDTO(
                        beneficiario.getId(),
                        beneficiario.getNombre(),
                        beneficiario.getTipo(),
                        beneficiario.getDireccion(),
                        beneficiario.getTelefono(),
                        beneficiario.getFechaRegistro()
                ))
                .collect(Collectors.toList());
    }

    // Buscar por ID (DTO)
    public BeneficiarioDTO obtenerPorId(Long id) {

        Beneficiario beneficiario = beneficiarioRepository.findById(id).orElse(null);

        if (beneficiario == null) {
            return null;
        }

        return new BeneficiarioDTO(
                beneficiario.getId(),
                beneficiario.getNombre(),
                beneficiario.getTipo(),
                beneficiario.getDireccion(),
                beneficiario.getTelefono(),
                beneficiario.getFechaRegistro()
        );
    }

    // Guardar (Entity)
    public Beneficiario guardar(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    // Actualizar (Entity)
    public Beneficiario actualizar(Long id, Beneficiario beneficiario) {

        Beneficiario existente = beneficiarioRepository.findById(id).orElse(null);

        if (existente == null) {
            return null;
        }

        existente.setNombre(beneficiario.getNombre());
        existente.setTipo(beneficiario.getTipo());
        existente.setDireccion(beneficiario.getDireccion());
        existente.setTelefono(beneficiario.getTelefono());

        return beneficiarioRepository.save(existente);
    }

    // Eliminar
    public void eliminar(Long id) {
        beneficiarioRepository.deleteById(id);
    }
}