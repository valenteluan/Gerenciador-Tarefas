package com.gerenciadortarefas.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Date;

public class AutenticacaoService {

    static public void addJWTToken(HttpServletResponse response, String username) {

        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.ES512, "signinKey")
                .compact();

        response.addHeader("Authorization", "Bearer " + jwtToken);
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    static public UsernamePasswordAuthenticationToken obterAutenticacao(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        if (token != null) {
            Claims user = Jwts.parser()
                    .setSigningKey("signinKey")
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, null);
            } else {
                throw new RuntimeException("Authenticação Falhou!");
            }
        }
        return null;
    }
}