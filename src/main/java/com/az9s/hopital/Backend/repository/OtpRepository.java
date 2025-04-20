package com.az9s.hopital.Backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.az9s.hopital.Backend.entity.OTP;

@Repository
public interface OtpRepository extends JpaRepository<OTP, Long> {
    Optional<OTP> findByPhone(String phone);
    Optional<OTP> findByPhoneAndOtp(String phone, String otp);
}
