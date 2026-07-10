package com.bancodealimentos26.donaciones26.controller;

import com.bancodealimentos26.donaciones26.model.Admin;
import com.bancodealimentos26.donaciones26.repository.AdminRepository;
import com.bancodealimentos26.donaciones26.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(AdminRepository adminRepository,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin request) {

        Admin admin = adminRepository.findByEmail(request.getEmail());

        if (admin == null) {
            return ResponseEntity.status(401).body("Administrador no encontrado");
        }

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            return ResponseEntity.status(401).body("Contraseña incorrecta");
        }

        String token = jwtService.generarToken(admin.getEmail(), admin.getRol().getNombre());

        return ResponseEntity.ok(
                Map.of(
                        "token", token,
                        "nombre", admin.getNombre(),
                        "email", admin.getEmail(),
                        "rol", admin.getRol().getNombre()
                )
        );
    }
}