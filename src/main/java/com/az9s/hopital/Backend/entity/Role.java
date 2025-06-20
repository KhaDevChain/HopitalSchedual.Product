package com.az9s.hopital.Backend.entity;

import java.io.Serializable;
import java.util.List;

import com.az9s.hopital.Backend.utils.dto.PermissionDTO;
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
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniqueId;

    @Column(name = "role_name", columnDefinition = "varchar(40)", nullable = false, unique = true)
    private String roleName;

    @OneToMany(
        mappedBy = "role",
        cascade = {CascadeType.MERGE, CascadeType.REFRESH},
        fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Permission> permissions;

    /**
     * Return data associated permissionDto
     * @return
     */
    public List<PermissionDTO> getPermissionsDTO() {
        return permissions == null ? null : permissions.stream().map(permission -> new PermissionDTO (
            permission.getUniqueId(),
            permission.getGroupName(),
            permission.getGroupPermission(),
            permission.getActivated(),
            permission.getDescription(),
            permission.getRole() == null ? null : permission.getRole().getUniqueId(),
            permission.getRole() == null ? null : permission.getRole().getRoleName(),
            null
        )).toList();
    }
}
