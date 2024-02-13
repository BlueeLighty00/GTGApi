package org.example.gtgapi.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.gtgapi.models.entity.Usuario;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class JWTAuthtenticationConfig {

    public String getJWTToken(Usuario usuario) {

        // Tiempo de vida del token: 1 semana
        long tiempoDeVidaMillis = 365 * 24 * 60 * 60 * 1000;  //365 días en milisegundos
        Date ahora = new Date();
        Date expiracion = new Date(ahora.getTime() + tiempoDeVidaMillis);

        String secretKey = "AlvarJCGod@VolvedOsHechoDeMenosPorFavor";

        List<GrantedAuthority> grantedAuthorities = usuario.getRolesAsociados().stream()
                .map(role -> new SimpleGrantedAuthority(role.toString()))
                .collect(Collectors.toList());

        String token = Jwts
                .builder()
                .setId(usuario.getId().toString())
                .setSubject(usuario.getUsername())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expiracion)
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

}
