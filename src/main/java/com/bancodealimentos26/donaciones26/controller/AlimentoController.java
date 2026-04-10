package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.model.Alimento;
import com.bancodealimentos26.donaciones26.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alimentos")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping
    public List<Alimento> listarAlimentos() {
        return alimentoService.listarAlimentos();
    }

    @PostMapping
    public Alimento guardarAlimento(@RequestBody Alimento alimento) {
        return alimentoService.guardarAlimento(alimento);
    }
}