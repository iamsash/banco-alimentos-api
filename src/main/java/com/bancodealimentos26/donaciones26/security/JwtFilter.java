package com.bancodealimentos26.donaciones26.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
protected boolean shouldNotFilter(HttpServletRequest request) {

    String path = request.getServletPath();

    return path.equals("/api/auth/login")

            || path.equals("/dashboard") || path.startsWith("/dashboard/")

            || path.equals("/alimentos") || path.startsWith("/alimentos/")

            || path.equals("/categorias") || path.startsWith("/categorias/")

            || path.equals("/donaciones") || path.startsWith("/donaciones/")

            || path.equals("/usuarios") || path.startsWith("/usuarios/")

            || path.equals("/beneficiarios") || path.startsWith("/beneficiarios/")

            || path.equals("/distribuciones") || path.startsWith("/distribuciones/")

            || path.equals("/inventario") || path.startsWith("/inventario/")

            || path.equals("/roles") || path.startsWith("/roles/");
}

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {

            String token = header.substring(7);

            if (jwtService.validarToken(token)) {

                String email = jwtService.extraerEmail(token);
                String rol = jwtService.extraerRol(token);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                email,
                                null,
                                List.of(new SimpleGrantedAuthority("ROLE_" + rol))
                        );

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}