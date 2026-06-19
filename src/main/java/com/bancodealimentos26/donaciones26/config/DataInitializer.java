package com.bancodealimentos26.donaciones26.config;

import com.bancodealimentos26.donaciones26.model.Rol;
import com.bancodealimentos26.donaciones26.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RolRepository rolRepository;

    public DataInitializer(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (rolRepository.findByNombre("ADMINISTRADOR").isEmpty()) {

            Rol administrador = new Rol();
            administrador.setNombre("ADMINISTRADOR");
            administrador.setDescripcion("Acceso completo al sistema");

            rolRepository.save(administrador);
        }

        if (rolRepository.findByNombre("TRABAJADOR").isEmpty()) {

            Rol trabajador = new Rol();
            trabajador.setNombre("TRABAJADOR");
            trabajador.setDescripcion("Acceso limitado al sistema");

            rolRepository.save(trabajador);
        }

        System.out.println("Roles inicializados correctamente.");

    }

}