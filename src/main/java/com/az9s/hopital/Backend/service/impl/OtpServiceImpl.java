package com.az9s.hopital.Backend.service.impl;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.OTP;
import com.az9s.hopital.Backend.repository.OtpRepository;
import com.az9s.hopital.Backend.service.OtpService;

@Service
public class OtpServiceImpl implements OtpService {
    @Autowired
    private OtpRepository otpRepository;

    @Override
    public void generateOtp(String phone) {
        String otp = String.format("%04d", new Random().nextInt(10000)); // OTP 4 số

        OTP request = new OTP();
        request.setPhone(phone);
        request.setOtp(otp);
        request.setCreatedAt(LocalDateTime.now());

        otpRepository.save(request);

        System.out.println("[ OTP for " + phone + ": " + otp + " ]");
    }

    @Override
    public boolean verifyOtp(String phone, String otp) {
        OTP request = otpRepository.findByPhone(phone).orElse(null);

        if (request == null) return false;

        // Kiểm tra thời gian sống 45s
        if (request.getCreatedAt().plusSeconds(45).isBefore(LocalDateTime.now())) {
            otpRepository.delete(request); // Hết hạn thì xóa
            return false;
        }

        if (request.getOtp().equals(otp)) {
            System.out.println("< OTP done = {" + phone + ": " + otp + "} >");
            otpRepository.delete(request); // Dùng xong thì xóa
            return true;
        }

        return false;
    }

    @Override
    public OTP findByPhone(String phone) {
        return otpRepository.findByPhone(phone).orElse(null);
    }

    @Override
    public OTP findByPhoneAndOtp(String phone, String otp) {
        return  otpRepository.findByPhoneAndOtp(phone, otp).orElse(null);
    }
    
}
