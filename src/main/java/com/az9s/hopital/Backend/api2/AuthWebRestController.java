package com.az9s.hopital.Backend.api2;

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
import org.springframework.web.bind.annotation.*;

import com.az9s.hopital.Backend.entity.Patient;
import com.az9s.hopital.Backend.entity.User;
import com.az9s.hopital.Backend.entity.UserRecord;
import com.az9s.hopital.Backend.security.core.UserDetailsImpl;
import com.az9s.hopital.Backend.security.jwt.JwtUtil;
import com.az9s.hopital.Backend.service.PatientService;
import com.az9s.hopital.Backend.service.RoleService;
import com.az9s.hopital.Backend.service.UserDetailSecurity;
import com.az9s.hopital.Backend.service.UserRecordService;
import com.az9s.hopital.Backend.service.UserService;
import com.az9s.hopital.Backend.utils.global.Parameters;
import com.az9s.hopital.Backend.utils.http.request.LoginRequest;
import com.az9s.hopital.Backend.utils.http.request.SignupRequest;
import com.az9s.hopital.Backend.utils.http.response.BasicResponse;
import com.az9s.hopital.Backend.utils.http.response.LoginResponse;
import com.az9s.hopital.Backend.utils.option.ActivateEnum;
import com.az9s.hopital.Backend.utils.option.GenderEnum;

@RestController
@RequestMapping("/api2/auth")
public class AuthWebRestController {

    @Autowired
    @Qualifier("cacheUserService")
    private UserService userService;

    @Autowired
    private UserRecordService userRecordService;

    @Autowired
    private PatientService patientService;

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
        userDetail.setAvatar(request.getAvatar());
        userDetail.setDateOfBirth(request.getDateOfBirth());
        userDetail.setFullName(request.getFullName());
        userDetail.setGender(request.getGender() ? GenderEnum.FEMALE : GenderEnum.MALE);
        userDetail.setUniqueId(UUID.randomUUID().toString());
        userDetail.setUser(user);

        userRecordService.saveUserDetail(userDetail);

        Patient patient = new Patient();
        patient.setUniqueId(UUID.randomUUID().toString());
        patient.setUser(user);
        patient.setUserRecord(userDetail);

        patientService.savePatient(patient);

        return ResponseEntity.ok(new BasicResponse("User registered successfully!", 200, patient));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getPhone(), request.getPassword())
        );
        UserDetailsImpl userDetails = userDetailSecurity.loadUserByEmailOrPhone(request.getPhone());
        String data = userDetails.getPhone();
        String token = JwtUtil.generateTokenHaveTime(data);

        Cookie cookie = new Cookie("AUTH_WEB_TOKEN", token);
        cookie.setMaxAge(Parameters.COOKIE_TOKEN_WEB_TIME);
        cookie.setHttpOnly(Parameters.IS_HTTP_ONLY);
        cookie.setSecure(Parameters.IS_SECURE);
        cookie.setPath("/");
        cookie.setDomain(Parameters.DOMAIN_HOST);
        cookie.setAttribute("SameSite", "Lax");
        response.addCookie(cookie);

        return ResponseEntity.ok(new LoginResponse(
            token, 
            userDetails.getPhone(),
            null
        ));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("AUTH_WEB_TOKEN", null);
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

