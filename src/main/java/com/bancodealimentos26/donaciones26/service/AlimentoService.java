package com.bancodealimentos26.donaciones26.service;

import com.bancodealimentos26.donaciones26.model.Alimento;
import com.bancodealimentos26.donaciones26.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    public List<Alimento> listarAlimentos() {
        return alimentoRepository.findAll();
    }

    public Alimento guardarAlimento(Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    public Optional<Alimento> buscarPorId(Long id) {
        return alimentoRepository.findById(id);
    }

    public void eliminarAlimento(Long id) {
        alimentoRepository.deleteById(id);
    }
}
