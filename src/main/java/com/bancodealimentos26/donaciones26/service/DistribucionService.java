package com.bancodealimentos26.donaciones26.service;

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

    public List<Distribucion> getAllDistribuciones() {
        return distribucionRepository.findAll();
    }

    public Distribucion guardar(Distribucion distribucion) {
        if (distribucion.getAlimento() != null && distribucion.getAlimento().getId() != null) {
            Alimento alimento = alimentoRepository.findById(distribucion.getAlimento().getId())
                    .orElseThrow(() -> new RuntimeException("Alimento no encontrado"));

            distribucion.setAlimento(alimento);
        }

        if (distribucion.getBeneficiario() != null && distribucion.getBeneficiario().getId() != null) {
            Beneficiario beneficiario = beneficiarioRepository.findById(distribucion.getBeneficiario().getId())
                    .orElseThrow(() -> new RuntimeException("Beneficiario no encontrado"));

            distribucion.setBeneficiario(beneficiario);
        }

        distribucion.setFecha(LocalDate.now());

        return distribucionRepository.save(distribucion);
    }
}