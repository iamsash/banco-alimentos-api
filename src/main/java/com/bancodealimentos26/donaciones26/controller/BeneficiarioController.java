package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.model.Beneficiario;
import com.bancodealimentos26.donaciones26.service.BeneficiarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
@CrossOrigin(origins = "*")
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @GetMapping
    public List<Beneficiario> listar() {
        return beneficiarioService.listar();
    }

    @GetMapping("/{id}")
    public Beneficiario obtenerPorId(@PathVariable Long id) {
        return beneficiarioService.obtenerPorId(id);
    }

    @PostMapping
    public Beneficiario guardar(@RequestBody Beneficiario beneficiario) {
        return beneficiarioService.guardar(beneficiario);
    }

    @PutMapping("/{id}")
    public Beneficiario actualizar(@PathVariable Long id, @RequestBody Beneficiario beneficiario) {
        return beneficiarioService.actualizar(id, beneficiario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        beneficiarioService.eliminar(id);
    }
}