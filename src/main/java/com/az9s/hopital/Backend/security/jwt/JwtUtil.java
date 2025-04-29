package com.az9s.hopital.Backend.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = System.getenv("SECRET_KEY");
    private static final long EXPIRATION_TIME = 3600 * 1000;

    private static Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public static String generateTokenHaveTime(String data) {
        try {
            return Jwts.builder()
            .setSubject(data)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
        } catch (Exception e) {
            return null;
        }
    }

    public static String generateTokenPushTime(String data, Long expirationTime) {
        try {
            return Jwts.builder()
            .setSubject(data)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getDataFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
