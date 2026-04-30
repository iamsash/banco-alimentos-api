package com.bancodealimentos26.donaciones26.service;

import com.bancodealimentos26.donaciones26.model.Distribucion;
import com.bancodealimentos26.donaciones26.repository.DistribucionRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;


    @Service
    public class DistribucionService {
        private final DistribucionRepository distribucionRepository;


        public DistribucionService(DistribucionRepository distribucionRepository) {
            this.distribucionRepository = distribucionRepository;
        }

        public List<Distribucion> getAllDistribuciones() {
            return distribucionRepository.findAll();
        }

       public Distribucion guardar(Distribucion distribucion) {
    distribucion.setFecha(LocalDate.now());
    return distribucionRepository.save(distribucion);
}

    
}
