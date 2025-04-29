package com.az9s.hopital.Backend.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;

import com.az9s.hopital.Backend.utils.dto.RoleDTO;
import com.az9s.hopital.Backend.utils.option.ActivateEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(
    name = "users",
    indexes = {
        @Index(name = "idx_user_email", columnList = "email"),
        @Index(name = "idx_user_phone", columnList = "phone"),
        @Index(name = "idx_user_activated", columnList = "activated")
    },
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"phone", "role_id"}),
        @UniqueConstraint(columnNames = {"email", "role_id"}),
        @UniqueConstraint(columnNames = {"email", "phone", "role_id"})
    }
)
public class User implements Serializable {
    @Id
    @Column(columnDefinition = "varchar(40)", nullable = false)
    private String uniqueId;

    @Column(columnDefinition = "varchar(13)", nullable = false, unique = true)
    private String phone;

    @Column(columnDefinition = "varchar(256)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String email;

    @Column(name = "created_at", columnDefinition = "datetime")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "activated", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivateEnum activated;

    /**
     * DỮ LIỆU LIÊN KẾT
     */
    @ManyToOne(
        cascade = {CascadeType.MERGE, CascadeType.REFRESH},
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserRecord userRecord;

    public RoleDTO getRoleDTO() {
        return role == null ? null : new RoleDTO(
            this.role.getUniqueId(),
            this.role.getRoleName(),
            this.role.getPermissions()
        );
    }
}
