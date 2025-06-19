package com.az9s.hopital.Backend.api2;

import java.util.Arrays;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az9s.hopital.Backend.security.jwt.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api2")
public class TokenWebRestController {
    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) {
        String refreshToken = Arrays.stream(request.getCookies())
            .filter(c -> "AUTH_WEB_REFRESH_TOKEN".equals(c.getName()))
            .findFirst()
            .map(Cookie::getValue)
            .orElse(null);

        if (refreshToken == null || !JwtUtil.validateToken(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
        }

        String subject = JwtUtil.getDataFromToken(refreshToken);
        String newAccessToken = JwtUtil.generateAccessTokenHaveTime(subject);
        return ResponseEntity.ok(Map.of("accessToken", newAccessToken));
    }
}
