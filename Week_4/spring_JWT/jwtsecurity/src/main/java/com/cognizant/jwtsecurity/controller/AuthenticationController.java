package com.cognizant.jwtsecurity.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@RestController
public class AuthenticationController {

    // Secret key for signing (use secure env in real life)
    private final Key key = Keys.hmacShaKeyFor("mysecretkey123456789012345678901234".getBytes());

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
        }

        // Decode Base64 credentials
        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded);
        final String[] values = credentials.split(":", 2);

        String username = values[0];
        String password = values[1];

        // Validate hardcoded user (simulate DB check)
        if (!("user".equals(username) && "pwd".equals(password))) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        // Build JWT
        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return ResponseEntity.ok("{\"token\":\"" + jwtToken + "\"}");
    }
}
