package com.az9s.hopital.Backend.entity;

import java.time.LocalDateTime;

import com.az9s.hopital.Backend.utils.option.AppointmentEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(
    name = "appointment",
    indexes = {
        @Index(name = "idx_appoint_status" , columnList = "status"),
        @Index(name = "idx_appoint_pat" , columnList = "patient_id"),
        @Index(name = "idx_appoint_checkupPart_id" , columnList = "checkupPart_id"),
        @Index(name = "idx_appoint_pat_status" , columnList = "patient_id, status"),
        @Index(name = "idx_appoint_doc_pat" , columnList = "doctor_id, patient_id"),
        @Index(name = "idx_appoint_pat_date" , columnList = "patient_id, booking_date"),
    }
)
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniqueId;

    @Column(name = "booking_date", columnDefinition = "datetime", nullable = false)
    private LocalDateTime bookingDate = LocalDateTime.now();

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AppointmentEnum status;

    @Column(name = "note", columnDefinition = "varchar(300)")
    private String note;

    @Column(name = "record_voice", columnDefinition = "varchar(100)")
    private String recordVoice;

    /**
     * DỮ LIỆU LIÊN KẾT
     */
    @ManyToOne(
        cascade = {CascadeType.MERGE, CascadeType.REFRESH},
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne(
        cascade = {CascadeType.MERGE, CascadeType.REFRESH},
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    
    @ManyToOne(
        cascade = {CascadeType.MERGE, CascadeType.REFRESH},
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "checkupPart_id", nullable = false)
    private CheckupPart checkupPart;
}
