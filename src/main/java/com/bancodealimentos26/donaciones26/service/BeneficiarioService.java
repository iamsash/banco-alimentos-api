package com.bancodealimentos26.donaciones26.service;

import com.bancodealimentos26.donaciones26.model.Beneficiario;
import com.bancodealimentos26.donaciones26.repository.BeneficiarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;

    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    public List<Beneficiario> listar() {
        return beneficiarioRepository.findAll();
    }

    public Beneficiario guardar(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    public Beneficiario obtenerPorId(Long id) {
        return beneficiarioRepository.findById(id).orElse(null);
    }

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

    public void eliminar(Long id) {
        beneficiarioRepository.deleteById(id);
    }
}