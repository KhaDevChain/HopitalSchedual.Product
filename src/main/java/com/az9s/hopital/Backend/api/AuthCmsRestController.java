package com.az9s.hopital.Backend.api;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az9s.hopital.Backend.entity.User;
import com.az9s.hopital.Backend.security.core.UserDetailsImpl;
import com.az9s.hopital.Backend.security.jwt.JwtUtil;
import com.az9s.hopital.Backend.service.RoleService;
import com.az9s.hopital.Backend.service.UserDetailSecurity;
import com.az9s.hopital.Backend.service.UserService;
import com.az9s.hopital.Backend.utils.global.Parameters;
import com.az9s.hopital.Backend.utils.http.request.LoginRequest;
import com.az9s.hopital.Backend.utils.http.request.SignupRequest;
import com.az9s.hopital.Backend.utils.http.response.BasicResponse;
import com.az9s.hopital.Backend.utils.http.response.LoginResponse;
import com.az9s.hopital.Backend.utils.option.ActivateEnum;

@RestController
@RequestMapping("/api/auth")
public class AuthCmsRestController {

    @Autowired
    @Qualifier("logicUserService")
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailSecurity userDetailSecurity;

    @Autowired
    @Qualifier("logicRoleService")
    private RoleService roleService;

    @Transactional
    @PostMapping("/signup")
    public ResponseEntity<?> signupCms(@RequestBody SignupRequest request) {
        if (userService.existsByPhone(request.getPhone())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Phone number already exists");
        }
        User user = new User();
        user.setUniqueId(UUID.randomUUID().toString());
        user.setPhone(request.getPhone());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setActivated(ActivateEnum.ACTIVE);
        user.setRole(roleService.findById(request.getRoleId()));

        userService.saveUser(user);
        return ResponseEntity.ok(new BasicResponse("User created successfully", 200, user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCms(@RequestBody LoginRequest request, HttpServletResponse response) {
        if (request.getEmail() == null || request.getEmail().isEmpty() ||
            request.getPassword() == null || request.getPassword().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incomplete login data");
        }

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserDetailsImpl userDetails = userDetailSecurity.loadUserByEmailOrPhone(request.getEmail());
        String data = userDetails.getEmail();
        String accessToken = JwtUtil.generateAccessTokenHaveTime(data);
        String refreshToken = JwtUtil.generateRefreshTokenHaveTime(data);

        addCookie(response, "AUTH_CMS_ACCESS_TOKEN", accessToken, Parameters.GENERAL_ACCESS_TOKEN_TIME);
        addCookie(response, "AUTH_CMS_REFRESH_TOKEN", refreshToken, Parameters.GENERAL_REFRESH_TOKEN_TIME);
        addCookie(response, "ACCESS_DATA_CMS", data, Parameters.GENERAL_REFRESH_TOKEN_TIME);

        return ResponseEntity.ok(new LoginResponse(accessToken, userDetails.getUser()));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutCms(HttpServletResponse response) {
        removeCookie(response, "AUTH_CMS_ACCESS_TOKEN");
        removeCookie(response, "AUTH_CMS_REFRESH_TOKEN");
        removeCookie(response, "ACCESS_DATA_CMS");

        return ResponseEntity.ok("Logout successful");
    }

    private void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(Parameters.IS_HTTP_ONLY);
        cookie.setSecure(Parameters.IS_SECURE);
        cookie.setPath("/");
        cookie.setDomain(Parameters.DOMAIN_HOST);
        cookie.setAttribute("SameSite", "Lax");
        response.addCookie(cookie);
    }

    private void removeCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(Parameters.COOKIE_OFF);
        cookie.setHttpOnly(Parameters.IS_HTTP_ONLY);
        cookie.setSecure(Parameters.IS_SECURE);
        cookie.setPath("/");
        cookie.setDomain(Parameters.DOMAIN_HOST);
        cookie.setAttribute("SameSite", "Lax");
        response.addCookie(cookie);
    }
}
