package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.model.Admin;
import com.bancodealimentos26.donaciones26.repository.AdminRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AdminRepository adminRepository;

    public AuthController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin request) {

        Admin admin = adminRepository.findByEmail(request.getEmail());

        if (admin == null) {
            return ResponseEntity.status(401).body("Admin no encontrado");
        }

        if (!admin.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        return ResponseEntity.ok(admin);
    }
}