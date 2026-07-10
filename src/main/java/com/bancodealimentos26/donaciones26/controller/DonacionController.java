package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.dto.DonacionDTO;
import com.bancodealimentos26.donaciones26.model.Donacion;
import com.bancodealimentos26.donaciones26.service.DonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donaciones")
@CrossOrigin(origins = "*")
public class DonacionController {

    @Autowired
    private DonacionService donacionService;

    // Listar donaciones (DTO)
    @GetMapping
    public List<DonacionDTO> listarDonaciones() {
        return donacionService.listarDonaciones();
    }

    // Buscar donación por ID (DTO)
    @GetMapping("/{id}")
    public DonacionDTO obtenerPorId(@PathVariable Long id) {
        return donacionService.buscarPorId(id);
    }

    // Guardar donación (Entity)
    @PostMapping
    public Donacion guardarDonacion(@RequestBody Donacion donacion) {
        return donacionService.guardarDonacion(donacion);
    }

    // Eliminar donación
    @DeleteMapping("/{id}")
    public void eliminarDonacion(@PathVariable Long id) {
        donacionService.eliminarDonacion(id);
    }

    // Actualizar donación (Entity)
    @PutMapping("/{id}")
public Donacion actualizarDonacion(@PathVariable Long id,
                                   @RequestBody Donacion donacion) {

    return donacionService.actualizarDonacion(id, donacion);
}

@GetMapping("/estadisticas/mes")
public List<Integer> obtenerDonacionesPorMes() {

    return donacionService.obtenerDonacionesPorMes();

}
} 