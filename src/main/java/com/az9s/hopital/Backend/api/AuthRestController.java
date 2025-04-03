package com.az9s.hopital.Backend.api;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.az9s.hopital.Backend.entity.User;
import com.az9s.hopital.Backend.entity.UserRecord;
import com.az9s.hopital.Backend.security.core.UserDetailsImpl;
import com.az9s.hopital.Backend.security.jwt.JwtUtil;
import com.az9s.hopital.Backend.service.RoleService;
import com.az9s.hopital.Backend.service.UserDetailSecurity;
import com.az9s.hopital.Backend.service.UserRecordService;
import com.az9s.hopital.Backend.service.UserService;
import com.az9s.hopital.Backend.utils.global.Parameters;
import com.az9s.hopital.Backend.utils.http.request.LoginRequest;
import com.az9s.hopital.Backend.utils.http.request.SignupRequest;
import com.az9s.hopital.Backend.utils.option.ActivateEnum;
import com.az9s.hopital.Backend.utils.option.GenderEnum;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRecordService userRecordService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailSecurity userDetailSecurity;

    @Autowired
    private RoleService roleService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        // Kiểm tra nếu số điện thoại đã tồn tại
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
        
        UserRecord userDetail = new UserRecord();
        userDetail.setAddress(request.getAddress());
        userDetail.setDateOfBirth(request.getDateOfBirth());
        userDetail.setFullName(request.getFullName());
        userDetail.setGender(GenderEnum.MALE);
        userDetail.setUniqueId(UUID.randomUUID().toString());
        userDetail.setUser(user);

        userRecordService.saveUserDetail(userDetail);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getPhone(), request.getPassword())
        );
        UserDetailsImpl userDetails = userDetailSecurity.loadUserByPhone(request.getPhone());
        String token = JwtUtil.generateToken(userDetails.getPhone());

        Cookie cookie = new Cookie("AUTH_TOKEN", token);
        cookie.setMaxAge(Parameters.COOKIE_TOKEN);
        cookie.setHttpOnly(Parameters.IS_HTTP_ONLY);
        cookie.setSecure(Parameters.IS_SECURE);
        cookie.setPath("/");
        cookie.setDomain(Parameters.DOMAIN_HOST);
        cookie.setAttribute("SameSite", "Lax");

        response.addCookie(cookie);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("AUTH_TOKEN", null);
        cookie.setMaxAge(Parameters.COOKIE_OFF);
        cookie.setHttpOnly(Parameters.IS_HTTP_ONLY);
        cookie.setSecure(Parameters.IS_SECURE);
        cookie.setPath("/");
        cookie.setDomain(Parameters.DOMAIN_HOST);
        cookie.setAttribute("SameSite", "Lax");

        response.addCookie(cookie);
        return ResponseEntity.ok("Logout successful");
    }
}

