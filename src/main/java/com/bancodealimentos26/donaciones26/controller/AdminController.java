package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.model.Admin;
import com.bancodealimentos26.donaciones26.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "*")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Listar administradores
    @GetMapping
    public List<Admin> listarAdmins() {
        return adminService.listarAdmins();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Admin> obtenerPorId(@PathVariable Long id) {

        Admin admin = adminService.obtenerPorId(id);

        if (admin == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(admin);
    }

    // Registrar administrador
    @PostMapping
    public Admin guardarAdmin(@RequestBody Admin admin) {
        return adminService.guardarAdmin(admin);
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Admin> actualizarAdmin(
            @PathVariable Long id,
            @RequestBody Admin admin) {

        Admin actualizado = adminService.actualizarAdmin(id, admin);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAdmin(@PathVariable Long id) {

        boolean eliminado = adminService.eliminarAdmin(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}