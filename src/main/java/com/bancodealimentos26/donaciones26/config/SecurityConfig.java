package com.bancodealimentos26.donaciones26.config;

import com.bancodealimentos26.donaciones26.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth

    // Login
    .requestMatchers("/api/auth/login").permitAll()
    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

    // CONSULTAS (ADMIN Y TRABAJADOR)
.requestMatchers("/dashboard/**").permitAll()

.requestMatchers("/inventario", "/inventario/**").permitAll()

.requestMatchers("/donaciones", "/donaciones/**").permitAll()

.requestMatchers("/distribuciones", "/distribuciones/**").permitAll()

.requestMatchers("/alimentos", "/alimentos/**").permitAll()

.requestMatchers("/categorias", "/categorias/**").permitAll()

.requestMatchers("/usuarios", "/usuarios/**").permitAll()

.requestMatchers("/beneficiarios", "/beneficiarios/**").permitAll()

.requestMatchers("/roles", "/roles/**").permitAll()
    // ===========================
    // SOLO ADMINISTRADOR
    // ===========================

    .requestMatchers("/administradores/**").hasRole("ADMINISTRADOR")
.requestMatchers(HttpMethod.POST, "/categorias", "/categorias/**").hasRole("ADMINISTRADOR")
.requestMatchers(HttpMethod.PUT, "/categorias", "/categorias/**").hasRole("ADMINISTRADOR")
.requestMatchers(HttpMethod.DELETE, "/categorias", "/categorias/**").hasRole("ADMINISTRADOR")

.requestMatchers(HttpMethod.POST, "/alimentos", "/alimentos/**").hasRole("ADMINISTRADOR")
.requestMatchers(HttpMethod.PUT, "/alimentos", "/alimentos/**").hasRole("ADMINISTRADOR")
.requestMatchers(HttpMethod.DELETE, "/alimentos", "/alimentos/**").hasRole("ADMINISTRADOR")

.requestMatchers(HttpMethod.POST, "/usuarios", "/usuarios/**").hasRole("ADMINISTRADOR")
.requestMatchers(HttpMethod.PUT, "/usuarios", "/usuarios/**").hasRole("ADMINISTRADOR")
.requestMatchers(HttpMethod.DELETE, "/usuarios", "/usuarios/**").hasRole("ADMINISTRADOR")

.requestMatchers(HttpMethod.POST, "/beneficiarios", "/beneficiarios/**").hasRole("ADMINISTRADOR")
.requestMatchers(HttpMethod.PUT, "/beneficiarios", "/beneficiarios/**").hasRole("ADMINISTRADOR")
.requestMatchers(HttpMethod.DELETE, "/beneficiarios", "/beneficiarios/**").hasRole("ADMINISTRADOR")

    .anyRequest().authenticated()
)

                

                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}