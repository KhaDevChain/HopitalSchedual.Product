package com.az9s.hopital.Backend.entity;

import java.time.LocalDate;

import com.az9s.hopital.Backend.utils.option.GenderEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_records")
public class UserRecord {

    @Id
    @Column(columnDefinition = "varchar(40)", nullable = false)
    private String uniqueId;

    @Column(name = "full_name", nullable = false, columnDefinition = "varchar(75)")
    private String fullName;

    @Column(name = "date_of_birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(name = "address", columnDefinition = "varchar(150)")
    private String address;

    @Column(name = "avatar", columnDefinition = "varchar(120)")
    private String avatar;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
