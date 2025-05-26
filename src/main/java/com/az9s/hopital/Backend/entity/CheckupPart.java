package com.az9s.hopital.Backend.entity;

import java.util.List;

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
@Table(name = "checkup_part")
public class CheckupPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniqueId;

    @Column(columnDefinition = "varchar(20)", nullable = false, unique = true)
    private String partName;

    @OneToMany(
        mappedBy = "checkupPart",
        cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, 
        fetch = FetchType.LAZY
    )
    private List<Department> departments;
}
