package com.az9s.hopital.Backend.entity;

import com.az9s.hopital.Backend.utils.option.BloodEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(
    name = "patients",
    indexes = {
        @Index(name = "idx_pati_user" , columnList = "user_id"),
        @Index(name = "idx_pati_user_udetal" , columnList = "user_id, user_detail_id"),
    },
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "user_detail_id"})
    }
)
public class Patient {

    @Id
    @Column(columnDefinition = "varchar(40)", nullable = false)
    private String uniqueId;

    @Column(name = "medical_history", columnDefinition = "text")
    private String medicalHistory;

    @Column(name = "blood_type", columnDefinition = "varchar(3)")
    @Enumerated(EnumType.STRING)
    private BloodEnum bloodType;

    @Column(name = "insurance_id", unique = true, columnDefinition = "varchar(50)")
    private String insuranceId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "user_detail_id", nullable = false)
    private UserDetail userDetail;
}
