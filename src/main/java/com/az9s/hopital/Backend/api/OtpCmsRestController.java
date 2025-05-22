package com.az9s.hopital.Backend.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az9s.hopital.Backend.service.OtpService;

@RestController
@RequestMapping("/api/auth")
public class OtpCmsRestController {
    @Autowired
    private OtpService otpService;

    @PostMapping("/phone-login")
    public ResponseEntity<String> loginWithPhone(@RequestBody Map<String, String> payload) {
        String phone = payload.get("phone");
        otpService.generateOtp(phone);
        return ResponseEntity.ok("OTP sent to phone: " + phone);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody Map<String, String> payload) {
        String phone = payload.get("phone");
        String otp = payload.get("otp");

        boolean isValid = otpService.verifyOtp(phone, otp);

        if (isValid) {
            return ResponseEntity.ok("Xác thực thành công");
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("OTP không hợp lệ hoặc đã hết hạn");
        }
    }
}
