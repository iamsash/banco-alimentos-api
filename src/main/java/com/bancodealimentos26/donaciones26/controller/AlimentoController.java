package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.dto.AlimentoDTO;
import com.bancodealimentos26.donaciones26.model.Alimento;
import com.bancodealimentos26.donaciones26.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/alimentos")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    // Listar alimentos (DTO)
    @GetMapping
    public List<AlimentoDTO> listarAlimentos() {
        return alimentoService.listarAlimentos();
    }

    // Obtener alimento por ID (DTO)
    @GetMapping("/{id}")
    public AlimentoDTO obtenerPorId(@PathVariable Long id) {
        return alimentoService.obtenerPorId(id);
    }

    // Guardar alimento (Entity)
    @PostMapping
    public Alimento guardarAlimento(@RequestBody Alimento alimento) {
        return alimentoService.guardarAlimento(alimento);
    }

    // Actualizar alimento (Entity)
    @PutMapping("/{id}")
    public Alimento actualizarAlimento(@PathVariable Long id,
                                       @RequestBody Alimento alimento) {
        return alimentoService.actualizarAlimento(id, alimento);
    }

    // Eliminar alimento
    @DeleteMapping("/{id}")
    public void eliminarAlimento(@PathVariable Long id) {
        alimentoService.eliminarAlimento(id);
    }
}