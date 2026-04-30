package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.model.Alimento;
import com.bancodealimentos26.donaciones26.service.AlimentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Esta clase recibe peticiones HTTP y devuelve datos (JSON)”
@RestController

//crea la ruta para el controlador de alimentos, con los métodos para listar y guardar alimentos.
@RequestMapping("/alimentos")

public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    // 🔹 LISTAR TODOS LOS ALIMENTOS
    @GetMapping
    public List<Alimento> listarAlimentos() {
        return alimentoService.listarAlimentos();
    }

    // 🔹 OBTENER UN ALIMENTO POR ID
    @GetMapping("/{id}")
    public Alimento obtenerPorId(@PathVariable Long id) {
        return alimentoService.obtenerPorId(id);
    }

    // 🔹 GUARDAR UN NUEVO ALIMENTO
    @PostMapping
    public Alimento guardarAlimento(@RequestBody Alimento alimento) {
        return alimentoService.guardarAlimento(alimento);
    }

    // 🔹 ACTUALIZAR UN ALIMENTO
    @PutMapping("/{id}")
    public Alimento actualizarAlimento(@PathVariable Long id, @RequestBody Alimento alimento) {
        return alimentoService.actualizarAlimento(id, alimento);
    }

    // 🔹 ELIMINAR UN ALIMENTO
    @DeleteMapping("/{id}")
    public String eliminarAlimento(@PathVariable Long id) {
        alimentoService.eliminarAlimento(id);
        return "Alimento eliminado correctamente";
    }
}