package com.az9s.hopital.Backend.security.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import com.az9s.hopital.Backend.security.core.UserDetailSecurityImpl;
import com.az9s.hopital.Backend.security.core.UserDetailsImpl;
import com.az9s.hopital.Backend.security.jwt.JwtUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {
    
    @Autowired
    private UserDetailSecurityImpl userDetailServiceImpl;

    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        Optional<String> tokenOpt = getTokenFromCookies(request);
        System.out.println("tokenOpt: " + tokenOpt);

        if (tokenOpt.isPresent()) {
            String token = tokenOpt.get();
            try {
                if (JwtUtil.validateToken(token)) {
                    String data = JwtUtil.getDataFromToken(token);
                    UserDetailsImpl userDetails = userDetailServiceImpl.loadUserByEmailOrPhone(data);
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    throw new IllegalStateException("Token not valid");
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }            
        }
        chain.doFilter(request, response);
    }

    private Optional<String> getTokenFromCookies(HttpServletRequest request) {
        if (request.getCookies() == null) return Optional.empty();

        String cookieName;
        if (request.getRequestURI().contains("/api/")) {
            cookieName = "AUTH_CMS_TOKEN";
        } else if (request.getRequestURI().contains("/api2/")) {
            cookieName = "AUTH_WEB_TOKEN";
        } else {
            cookieName = "NONE";
        }
        
        return Arrays.stream(request.getCookies())
                .filter(cookie -> cookieName.equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst();
    }
}


