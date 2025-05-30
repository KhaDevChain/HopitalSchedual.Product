package com.az9s.hopital.Backend.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.az9s.hopital.Backend.utils.option.ActivateEnum;
import com.az9s.hopital.Backend.utils.option.HopitalTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "hopitals",
    indexes = {
        @Index(name = "idx_hopital_name" , columnList = "name"),
        @Index(name = "idx_hopital_taxCode" , columnList = "tax_code")
    }
)
public class Hopital {
    @Id
    @Column(columnDefinition = "varchar(40)", nullable = false)
    private String uniqueId;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(80)")
    private String name;

    @Column(name = "code", nullable = false, unique = true, columnDefinition = "varchar(15)")
    private String code;

    @Column(name = "address", nullable = false, columnDefinition = "varchar(120)")
    private String address;

    @Column(name = "email", unique = true, columnDefinition = "varchar(70)")
    private String email;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private HopitalTypeEnum type;

    @Column(name = "tax_code", unique = true, nullable = true, columnDefinition = "varchar(15)")
    private String taxCode;

    @Column(name = "website", unique = true, columnDefinition = "varchar(80)")
    private String website;

    @Column(name = "open_work", columnDefinition = "varchar(8)")
    private String openWork;

    @Column(name = "close_work", columnDefinition = "varchar(8)")
    private String closeWork;

    @Column(name = "logo", nullable = false, columnDefinition = "varchar(50)")
    private String logo;

    @Column(name = "contract", unique = false, columnDefinition = "varchar(50)")
    private String contract;

    @Column(name = "represent_name", columnDefinition = "varchar(60)")
    private String representName;

    @Column(name = "represent_job", columnDefinition = "varchar(60)")
    private String representJob;

    @Column(name = "activated", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivateEnum activated;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(
        mappedBy = "hopital",
        cascade = {CascadeType.MERGE, CascadeType.REFRESH},
        fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Doctor> doctors;
}
