package com.bancodealimentos26.donaciones26.service;
import com.bancodealimentos26.donaciones26.dto.DistribucionDTO;
import com.bancodealimentos26.donaciones26.exception.RecursoNoEncontradoException;

import com.bancodealimentos26.donaciones26.model.Alimento;
import com.bancodealimentos26.donaciones26.model.Beneficiario;
import com.bancodealimentos26.donaciones26.model.Distribucion;
import com.bancodealimentos26.donaciones26.repository.AlimentoRepository;
import com.bancodealimentos26.donaciones26.repository.BeneficiarioRepository;
import com.bancodealimentos26.donaciones26.repository.DistribucionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DistribucionService {

    public DistribucionDTO convertirADTO(Distribucion distribucion) {
    return new DistribucionDTO(
            distribucion.getId(),
            distribucion.getCantidad(),
            distribucion.getFecha() != null ? distribucion.getFecha().toString() : null,
            distribucion.getBeneficiario().getId(),
            distribucion.getBeneficiario().getNombre(),
            distribucion.getAlimento().getId(),
            distribucion.getAlimento().getNombre()
    );
}

    private final DistribucionRepository distribucionRepository;
    private final AlimentoRepository alimentoRepository;
    private final BeneficiarioRepository beneficiarioRepository;

    public DistribucionService(
            DistribucionRepository distribucionRepository,
            AlimentoRepository alimentoRepository,
            BeneficiarioRepository beneficiarioRepository
    ) {
        this.distribucionRepository = distribucionRepository;
        this.alimentoRepository = alimentoRepository;
        this.beneficiarioRepository = beneficiarioRepository;
    }

   public List<DistribucionDTO> getAllDistribuciones() {
    return distribucionRepository.findAll()
            .stream()
            .map(this::convertirADTO)
            .toList();
}

    public Distribucion guardar(Distribucion distribucion) {

    Alimento alimento = alimentoRepository
            .findById(distribucion.getAlimento().getId())
            .orElse(null);

    if (alimento == null) {
        throw new RecursoNoEncontradoException("Alimento no encontrado");
    }

    distribucion.setAlimento(alimento);

    Beneficiario beneficiario = beneficiarioRepository
            .findById(distribucion.getBeneficiario().getId())
            .orElse(null);

    if (beneficiario == null) {
        throw new RecursoNoEncontradoException("Beneficiario no encontrado");
    }

    distribucion.setBeneficiario(beneficiario);

    distribucion.setFecha(LocalDate.now());

    return distribucionRepository.save(distribucion);
}
}