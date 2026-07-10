package com.bancodealimentos26.donaciones26.service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.bancodealimentos26.donaciones26.model.Admin;
import com.bancodealimentos26.donaciones26.model.Rol;
import com.bancodealimentos26.donaciones26.repository.AdminRepository;
import com.bancodealimentos26.donaciones26.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository,
                        RolRepository rolRepository,
                        PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Admin> listarAdmins() {
        return adminRepository.findAll();
    }

    public Admin obtenerPorId(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin guardarAdmin(Admin admin) {

        Rol rol = rolRepository.findById(admin.getRol().getId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        admin.setRol(rol);
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

    public Admin actualizarAdmin(Long id, Admin adminActualizado) {

        Admin admin = adminRepository.findById(id).orElse(null);

        if (admin == null) {
            return null;
        }

        Rol rol = rolRepository.findById(adminActualizado.getRol().getId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        admin.setNombre(adminActualizado.getNombre());
        admin.setEmail(adminActualizado.getEmail());
        admin.setPassword(passwordEncoder.encode(adminActualizado.getPassword()));
        admin.setRol(rol);

        return adminRepository.save(admin);
    }

    public boolean eliminarAdmin(Long id) {

        if (!adminRepository.existsById(id)) {
            return false;
        }

        adminRepository.deleteById(id);

        return true;
    }

}