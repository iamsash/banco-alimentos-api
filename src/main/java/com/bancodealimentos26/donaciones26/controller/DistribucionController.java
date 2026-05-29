package com.bancodealimentos26.donaciones26.controller;
import com.bancodealimentos26.donaciones26.dto.DistribucionDTO;
import com.bancodealimentos26.donaciones26.model.Distribucion;
import com.bancodealimentos26.donaciones26.service.DistribucionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distribuciones")
@CrossOrigin(origins = "*")
public class DistribucionController {

    private final DistribucionService distribucionService;

    public DistribucionController(DistribucionService distribucionService) {
        this.distribucionService = distribucionService;
    }

   @GetMapping
public List<DistribucionDTO> getAllDistribuciones() {
    return distribucionService.getAllDistribuciones();
}
    @PostMapping
    public Distribucion createDistribucion(@RequestBody Distribucion distribucion) {
        return distribucionService.guardar(distribucion);
    }
}