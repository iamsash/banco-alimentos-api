package com.bancodealimentos26.donaciones26.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;



import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    // Debe tener al menos 32 bytes para HS256
private static final String SECRET =
        "BancoAlimentos2026ProyectoFinalJWTClaveUltraSeguraParaSpringBootHS256OpenAI";

    private static final SecretKey KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    // 24 horas
    private static final long EXPIRATION = 1000L * 60 * 60 * 24;

    public String generarToken(String email, String rol) {

    return Jwts.builder()
            .subject(email)
            .claim("rol", rol)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .signWith(KEY)
            .compact();

}

public String extraerEmail(String token) {
    return Jwts.parser()
            .verifyWith(KEY)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
}

public String extraerRol(String token) {

    Claims claims = Jwts.parser()
            .verifyWith(KEY)
            .build()
            .parseSignedClaims(token)
            .getPayload();

    return claims.get("rol", String.class);

}

public boolean validarToken(String token) {
    try {
        Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token);
        return true;
    } catch (JwtException | IllegalArgumentException e) {
        return false;
    }
}



}