package com.az9s.hopital.Backend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.az9s.hopital.Backend.utils.option.ActivateEnum;

@Entity
@Table(
    name = "permissions", 
    indexes = {
        @Index(name = "idx_perms_activated" , columnList = "activated"),
        @Index(name = "idx_perms_group_activated" , columnList = "unique_id, activated"),
    },
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"group_name", "group_permission"}),
        @UniqueConstraint(columnNames = {"group_name", "group_permission", "activated"})
    }
)
@Data
public class Permission implements Serializable {
    @Id
    @Column(name = "unique_id", columnDefinition = "varchar(40)", nullable = false)
    private String uniqueId;

    @Column(name = "group_name", columnDefinition = "varchar(40)", nullable = false, unique = true)
    private String groupName;

    @Column(name = "group_permission", columnDefinition = "varchar(300)", nullable = false)
    private String groupPermission;

    @Column(name = "description", columnDefinition = "varchar(40)")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "activated", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivateEnum activated;

    @ManyToOne(
        cascade = {CascadeType.MERGE, CascadeType.REFRESH},
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
