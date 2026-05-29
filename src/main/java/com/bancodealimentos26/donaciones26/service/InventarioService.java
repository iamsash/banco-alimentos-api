package com.bancodealimentos26.donaciones26.service;

import com.bancodealimentos26.donaciones26.dto.InventarioDTO;
import com.bancodealimentos26.donaciones26.model.Alimento;
import com.bancodealimentos26.donaciones26.model.Donacion;
import com.bancodealimentos26.donaciones26.model.Distribucion;
import com.bancodealimentos26.donaciones26.repository.AlimentoRepository;
import com.bancodealimentos26.donaciones26.repository.DonacionRepository;
import com.bancodealimentos26.donaciones26.repository.DistribucionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventarioService {

    private final AlimentoRepository alimentoRepository;
    private final DonacionRepository donacionRepository;
    private final DistribucionRepository distribucionRepository;

    public InventarioService(
            AlimentoRepository alimentoRepository,
            DonacionRepository donacionRepository,
            DistribucionRepository distribucionRepository
    ) {
        this.alimentoRepository = alimentoRepository;
        this.donacionRepository = donacionRepository;
        this.distribucionRepository = distribucionRepository;
    }

    public List<InventarioDTO> listarInventario() {

        List<Alimento> alimentos = alimentoRepository.findAll();
        List<Donacion> donaciones = donacionRepository.findAll();
        List<Distribucion> distribuciones = distribucionRepository.findAll();

        List<InventarioDTO> inventario = new ArrayList<>();

        for (Alimento alimento : alimentos) {

            double totalDonado = 0;
            double totalDistribuido = 0;

            for (Donacion donacion : donaciones) {
                if (donacion.getAlimento() != null &&
                    donacion.getAlimento().getId().equals(alimento.getId())) {
                    totalDonado += donacion.getCantidad();
                }
            }

            for (Distribucion distribucion : distribuciones) {
                if (distribucion.getAlimento() != null &&
                    distribucion.getAlimento().getId().equals(alimento.getId())) {
                    totalDistribuido += distribucion.getCantidad();
                }
            }

            double stockActual = totalDonado - totalDistribuido;

            String categoriaNombre = alimento.getCategoria() != null
                    ? alimento.getCategoria().getNombre()
                    : "Sin categoría";

            InventarioDTO item = new InventarioDTO(
                    alimento.getId(),
                    alimento.getNombre(),
                    categoriaNombre,
                    alimento.getUnidadMedida(),
                    totalDonado,
                    totalDistribuido,
                    stockActual
            );

            inventario.add(item);
        }

        return inventario;
    }
}
