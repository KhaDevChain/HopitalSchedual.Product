package com.az9s.hopital.Backend.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.az9s.hopital.Backend.utils.option.ActivateEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniqueId;

    @Column(columnDefinition = "varchar(60)", nullable = false, unique = true)
    private String departmentName;

    @Column(columnDefinition = "varchar(60)", nullable = false, unique = true)
    private String note;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "activated", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivateEnum activated;

    @ManyToOne(
        cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "checkuppart_id", nullable = false)
    private CheckupPart checkupPart;

    @OneToMany(
        mappedBy = "department",
        cascade = {CascadeType.MERGE, CascadeType.REFRESH},
        fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Specialty> specialties;
}
