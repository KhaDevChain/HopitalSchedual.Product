package com.az9s.hopital.Backend.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
        @Index(name = "idx_hopital_name" , columnList = "name")
    }
)
public class Hopital {
    @Id
    @Column(columnDefinition = "varchar(40)", nullable = false)
    private String uniqueId;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(80)")
    private String name;

    @Column(name = "address", nullable = false, columnDefinition = "varchar(120)")
    private String address;

    @Column(name = "tax_code", unique = true, nullable = true, columnDefinition = "varchar(15)")
    private String taxCode;

    @Column(name = "website", unique = true, columnDefinition = "varchar(80)")
    private String website;

    @Column(name = "logo", nullable = false, columnDefinition = "varchar(80)")
    private String logo;

    @Column(name = "contract", nullable = false, columnDefinition = "varchar(60)")
    private String contract;

    @OneToMany(
        mappedBy = "hopital",
        cascade = {CascadeType.MERGE, CascadeType.REFRESH},
        fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Doctor> doctors;
}
