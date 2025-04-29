package com.az9s.hopital.Backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "pharmacies",
    indexes = {
        @Index(name = "idx_pharmacy_tax_code" , columnList = "tax_code")
    }
)
public class Pharmacy {
    @Id
    @Column(columnDefinition = "varchar(40)", nullable = false)
    private String uniqueId;

    @Column(name = "license_number", nullable = false, columnDefinition = "varchar(15)")
    private String licenseNumber;

    @Column(name = "tax_code", unique = true, nullable = true, columnDefinition = "varchar(15)")
    private String taxCode;

    @Column(name = "website", unique = true, columnDefinition = "varchar(80)")
    private String website;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "user_record_id", nullable = false)
    private UserRecord userRecord;
}
