package com.rapido.communication_service.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Date;

@RestController
public class JwtTestController {

    private static final String SECRET =
            "mysecretkeymysecretkeymysecretkey12345";

    private static final SecretKey KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    @GetMapping("/test-token")
    public String generateToken() {

        return Jwts.builder()
                .setSubject("101")
                .claim("role", "RIDER")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(KEY)
                .compact();
    }
}