package com.bancodealimentos26.donaciones26.controller;

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

    @GetMapping
    public List<Donacion> listarDonaciones() {
        return donacionService.listarDonaciones();
    }

    @PostMapping
    public Donacion guardarDonacion(@RequestBody Donacion donacion) {
        return donacionService.guardarDonacion(donacion);
    }
}