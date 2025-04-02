package com.az9s.hopital.Backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "doctors",
    indexes = {
        @Index(name = "idx_doctor_user" , columnList = "user_id"),
        @Index(name = "idx_doctor_user_udetal" , columnList = "user_id, user_detail_id"),
    },
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "user_detail_id"})
    }
)
public class Doctor {

    @Id
    @Column(columnDefinition = "varchar(40)", nullable = false)
    private String uniqueId;

    @Column(name = "specialization", nullable = false, columnDefinition = "varchar(255)")
    private String specialization;

    @Column(name = "experience_years")
    private int experienceYears;

    @Column(name = "license_number", unique = true, columnDefinition = "varchar(50)")
    private String licenseNumber;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "user_detail_id", nullable = false)
    private UserDetail userDetail;
}