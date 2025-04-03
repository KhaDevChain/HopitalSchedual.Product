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

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        Optional<String> tokenOpt = getTokenFromCookies(request);

        if (tokenOpt.isPresent()) {
            String token = tokenOpt.get();
            
            if (JwtUtil.validateToken(token)) {
                String phone = JwtUtil.getPhoneFromToken(token);
                UserDetailsImpl userDetails = userDetailServiceImpl.loadUserByPhone(phone);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new IllegalStateException("Token not valid");
            }
        }
        chain.doFilter(request, response);
    }

    private Optional<String> getTokenFromCookies(HttpServletRequest request) {
        if (request.getCookies() == null) return Optional.empty();

        return Arrays.stream(request.getCookies())
                .filter(cookie -> "AUTH_TOKEN".equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst();
    }
}


