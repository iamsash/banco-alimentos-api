package com.bancodealimentos26.donaciones26.service;

import com.bancodealimentos26.donaciones26.model.Alimento;
import com.bancodealimentos26.donaciones26.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    public List<Alimento> listarAlimentos() {
        return alimentoRepository.findAll();

    }
    public Alimento obtenerPorId(Long id) {
        return alimentoRepository.findById(id).orElse(null);
         
    }

    public Alimento guardarAlimento(Alimento alimento) {
        alimento.setFechaRegistro(LocalDate.now());
        return alimentoRepository.save(alimento);
    }

    public void eliminarAlimento(Long id) {
        alimentoRepository.deleteById(id);
    }

    public Alimento actualizarAlimento(Long id, Alimento alimentoActualizado) {
        Alimento alimento = alimentoRepository.findById(id).orElse(null);

        if (alimento != null) {
            alimento.setNombre(alimentoActualizado.getNombre());
            alimento.setDescripcion(alimentoActualizado.getDescripcion());
            alimento.setUnidadMedida(alimentoActualizado.getUnidadMedida());
            return alimentoRepository.save(alimento);
        }

        return null;
    }
}