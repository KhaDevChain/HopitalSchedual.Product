package com.az9s.hopital.Backend.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = System.getenv("SECRET_KEY");
    private static Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    private static final long REFRESH_EXPIRATION_TIME = 1 * 60 * 1000; // 1 phút
    private static final long ACCESS_EXPIRATION_TIME  = 5 * 60 * 1000; // 5 phút

    // Tạo token có thời hạn mặc định (1 giờ)
    public static String generateRefreshTokenHaveTime(String data) {
        try {
            return Jwts.builder()
                    .setSubject(data)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + REFRESH_EXPIRATION_TIME))
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();
        } catch (Exception e) {
            System.err.println("Error generating token: " + e.getMessage());
            return null;
        }
    }

    // Tạo token có thời hạn mặc định (1 giờ)
    public static String generateAccessTokenHaveTime(String data) {
        try {
            return Jwts.builder()
                    .setSubject(data)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + ACCESS_EXPIRATION_TIME))
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();
        } catch (Exception e) {
            System.err.println("Error generating token: " + e.getMessage());
            return null;
        }
    }

    // Tạo token với thời gian truyền vào
    public static String generateTokenPushTime(String data, Long expirationTime) {
        try {
            return Jwts.builder()
                    .setSubject(data)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();
        } catch (Exception e) {
            System.err.println("Error generating token with custom time: " + e.getMessage());
            return null;
        }
    }

    // Lấy subject (data) từ token
    public static String getDataFromToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            System.err.println("Error extracting data from token: " + e.getMessage());
            return null;
        }
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.err.println(">>> JWT token is expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.err.println(">>> JWT token is unsupported: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.err.println(">>> JWT token is malformed: " + e.getMessage());
        } catch (@SuppressWarnings("deprecation") SignatureException e) {
            System.err.println(">>> JWT signature is invalid: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(">>> JWT token is null or empty: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(">>> Unknown JWT validation error: " + e.getMessage());
        }

        return false;
    }
}
