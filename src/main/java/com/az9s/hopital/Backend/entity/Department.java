package com.az9s.hopital.Backend.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @OneToMany(
        mappedBy = "department",
        cascade = {CascadeType.MERGE, CascadeType.REFRESH},
        fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Specialty> specialties;
}
