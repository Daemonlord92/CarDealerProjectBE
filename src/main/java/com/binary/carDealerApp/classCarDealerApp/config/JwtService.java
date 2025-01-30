package com.binary.carDealerApp.classCarDealerApp.config;

import com.binary.carDealerApp.classCarDealerApp.entities.UserCredential;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Autowired
    private JwtConfigProperty jwtConfigProperty;

    @Autowired
    private UserDetailsService userDetailsService;

    public String generateToken(String username) {
        UserCredential userCredential = (UserCredential) userDetailsService.loadUserByUsername(username);
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", userCredential.getUsername());
        claims.put("role", userCredential.getRole());
        return generateToken(claims, userCredential);
    }

    private String generateToken(Map<String, Object> claims, UserCredential userCredential) {
        return Jwts.builder()
                .claims(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + jwtConfigProperty.getExpiration()))
                .signWith(getSecretKey())
                .compact();
    }

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtConfigProperty.getSecret());
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
