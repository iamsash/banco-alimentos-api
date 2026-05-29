package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.dto.InventarioDTO;
import com.bancodealimentos26.donaciones26.service.InventarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
@CrossOrigin(origins = "*")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public List<InventarioDTO> listarInventario() {
        return inventarioService.listarInventario();
    }
}