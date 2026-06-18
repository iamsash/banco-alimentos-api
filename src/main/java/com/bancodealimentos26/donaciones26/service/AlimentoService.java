package com.bancodealimentos26.donaciones26.service;


import com.bancodealimentos26.donaciones26.dto.AlimentoDTO;
import java.util.stream.Collectors;
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


    public List<AlimentoDTO> listarAlimentos() {

    return alimentoRepository.findAll()
            .stream()
            .map(alimento -> new AlimentoDTO(
                    alimento.getId(),
                    alimento.getNombre(),
                    alimento.getDescripcion(),
                    alimento.getUnidadMedida(),
                    alimento.getFechaRegistro(),
                    alimento.getCategoria()
            ))
            .collect(Collectors.toList());
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

  public AlimentoDTO obtenerPorId(Long id) {

    Alimento alimento = alimentoRepository.findById(id).orElse(null);

    if (alimento == null) {
        return null;
    }

return new AlimentoDTO(
        alimento.getId(),
        alimento.getNombre(),
        alimento.getDescripcion(),
        alimento.getUnidadMedida(),
        alimento.getFechaRegistro(),
        alimento.getCategoria()
);
}}
