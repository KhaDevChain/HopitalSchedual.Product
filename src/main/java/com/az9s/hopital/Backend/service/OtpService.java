package com.az9s.hopital.Backend.service;

import com.az9s.hopital.Backend.entity.OTP;

public interface OtpService {
    void generateOtp(String phone);
    boolean verifyOtp(String phone, String otp);
    OTP findByPhone(String phone);
    OTP findByPhoneAndOtp(String phone, String otp);
}
