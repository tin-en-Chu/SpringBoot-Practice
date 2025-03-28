package com.example.demo.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;


/**
 * spring security
 * 組要透過 Header + Payload(request's values) + Secret key(create by self)組成
 */
public class JwtService {
    private final SecretKey secretKey;
    private final int validSeconds;

    public JwtService(String secretKey, int validSeconds) {
        this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes());
        this.validSeconds = validSeconds;
    }


    public String createLoginAccessToken(UserDetails user) {
        // 計算過期時間
        long expirationMillis = Instant.now()
                .plusSeconds(validSeconds)
                .getEpochSecond()
                * 1000;

        // 準備 payload 內容
        Claims claims = Jwts.claims()
                .issuedAt(new Date())
                .expiration(new Date(expirationMillis))
                .add("username", user.getUsername())
                .add("authorities", user.getAuthorities())
                .build();

        // 簽名後產生 JWT
        return Jwts.builder()
                .claims(claims)
                .signWith(secretKey)
                .compact();
    }
}
