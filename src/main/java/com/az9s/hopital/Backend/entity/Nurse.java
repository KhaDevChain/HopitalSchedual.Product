package com.az9s.hopital.Backend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    name = "nurses",
    indexes = {
        @Index(name = "idx_nurse_user" , columnList = "user_id"),
        @Index(name = "idx_nurse_spec" , columnList = "specialty_id"),
        @Index(name = "idx_nurse_hopital" , columnList = "hopital_id"),
        @Index(name = "idx_nurse_user_udetal" , columnList = "user_id, user_record_id"),
    },
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "user_record_id"})
    }
)
public class Nurse {
    @Id
    @Column(columnDefinition = "varchar(40)", nullable = false)
    private String uniqueId;

    @Column(name = "specialization", nullable = false, columnDefinition = "varchar(255)")
    private String specialization;

    @Column(name = "nurse_code", unique = true, nullable = false)
    private String nurseCode;

    @Column(name = "license_number", unique = true, columnDefinition = "varchar(50)")
    private String licenseNumber;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "user_record_id", nullable = false)
    private UserRecord userRecord;

    /**
     * DỮ LIỆU LIÊN KẾT
     */
    @ManyToOne(
        cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "specialty_id", nullable = false)
    private Specialty specialty;

    @ManyToOne(
        cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "hopital_id", nullable = false)
    private Hopital hopital;
}
