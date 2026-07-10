package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.dto.DashboardDTO;
import com.bancodealimentos26.donaciones26.repository.AdminRepository;
import com.bancodealimentos26.donaciones26.repository.AlimentoRepository;
import com.bancodealimentos26.donaciones26.repository.BeneficiarioRepository;
import com.bancodealimentos26.donaciones26.repository.CategoriaRepository;
import com.bancodealimentos26.donaciones26.repository.DistribucionRepository;
import com.bancodealimentos26.donaciones26.repository.DonacionRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class DashboardController {

    private final AlimentoRepository alimentoRepository;
    private final DonacionRepository donacionRepository;
    private final BeneficiarioRepository beneficiarioRepository;
    private final DistribucionRepository distribucionRepository;
    private final CategoriaRepository categoriaRepository;
    private final AdminRepository adminRepository;

    public DashboardController(
            AlimentoRepository alimentoRepository,
            DonacionRepository donacionRepository,
            BeneficiarioRepository beneficiarioRepository,
            DistribucionRepository distribucionRepository,
            CategoriaRepository categoriaRepository,
            AdminRepository adminRepository) {

        this.alimentoRepository = alimentoRepository;
        this.donacionRepository = donacionRepository;
        this.beneficiarioRepository = beneficiarioRepository;
        this.distribucionRepository = distribucionRepository;
        this.categoriaRepository = categoriaRepository;
        this.adminRepository = adminRepository;
    }

    @GetMapping("/dashboard/resumen")
    public DashboardDTO obtenerResumen() {

        return new DashboardDTO(
                alimentoRepository.count(),
                donacionRepository.count(),
                beneficiarioRepository.count(),
                distribucionRepository.count(),
                categoriaRepository.count(),
                adminRepository.count()
        );
    }
}