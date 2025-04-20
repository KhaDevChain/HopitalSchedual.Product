package com.az9s.hopital.Backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(
    name = "otps",
    indexes = {
        @Index(name = "idx_phone_" , columnList = "phone"),
        @Index(name = "idx_one_otp" , columnList = "otp"),
        @Index(name = "idx_phone_otp" , columnList = "phone, otp")
    }
)
public class OTP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "phone", columnDefinition = "varchar(13)", nullable = false)
    private String phone;

    @Column(name = "otp", columnDefinition = "varchar(5)", nullable = false)
    private String otp;

    @Column(name = "created_at", columnDefinition = "datetime")
    private LocalDateTime createdAt = LocalDateTime.now();
}
