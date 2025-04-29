package com.az9s.hopital.Backend.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniqueId;

    @Column(columnDefinition = "varchar(70)", nullable = false, unique = true)
    private String specialtyName;

    @ManyToOne(
        cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(
        mappedBy = "specialty",
        cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, 
        fetch = FetchType.LAZY
    )
    private List<Doctor> doctors;

    @OneToMany(
        mappedBy = "specialty",
        cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, 
        fetch = FetchType.LAZY
    )
    private List<Nurse> nurses;
}
