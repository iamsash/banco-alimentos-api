package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.dto.AlimentoDTO;
import com.bancodealimentos26.donaciones26.model.Alimento;
import com.bancodealimentos26.donaciones26.service.AlimentoService;
import jakarta.validation.Valid; // <-- NUEVO IMPORT
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/alimentos")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping
    public List<AlimentoDTO> listarAlimentos() {
        return alimentoService.listarAlimentos();
    }

    @GetMapping("/{id}")
    public AlimentoDTO obtenerPorId(@PathVariable Long id) {
        return alimentoService.obtenerPorId(id);
    }

    @PostMapping
    public Alimento guardarAlimento(@Valid @RequestBody Alimento alimento) { // <-- @Valid AGREGADO AQUÍ
        return alimentoService.guardarAlimento(alimento);
    }

    @PutMapping("/{id}")
    public Alimento actualizarAlimento(@PathVariable Long id,
                                       @Valid @RequestBody Alimento alimento) { // <-- @Valid AGREGADO AQUÍ
        return alimentoService.actualizarAlimento(id, alimento);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlimento(@PathVariable Long id) {
        alimentoService.eliminarAlimento(id);
    }
}