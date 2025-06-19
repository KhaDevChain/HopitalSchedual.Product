package com.az9s.hopital.Backend.api2;

import java.util.Arrays;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az9s.hopital.Backend.security.jwt.JwtUtil;
import com.az9s.hopital.Backend.utils.global.Parameters;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api2")
public class TokenWebRestController {
    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response) {
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

        // Cập nhật refresh token vào cookie
        Cookie cookieAccess = new Cookie("AUTH_WEB_ACCESS_TOKEN", newAccessToken);
        cookieAccess.setMaxAge(Parameters.GENERAL_ACCESS_TOKEN_TIME);
        cookieAccess.setHttpOnly(Parameters.IS_HTTP_ONLY);
        cookieAccess.setSecure(Parameters.IS_SECURE);
        cookieAccess.setPath("/");
        cookieAccess.setDomain(Parameters.DOMAIN_HOST);
        cookieAccess.setAttribute("SameSite", "Lax");
        response.addCookie(cookieAccess);

        return ResponseEntity.ok(Map.of("accessToken", newAccessToken));
    }
}
