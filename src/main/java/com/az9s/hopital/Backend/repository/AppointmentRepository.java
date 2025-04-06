package com.az9s.hopital.Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.az9s.hopital.Backend.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("SELECT o FROM Appointment o WHERE o.patient.uniqueId = ?1")
    List<Appointment> findByPatientId(String patientId);

    @Query("SELECT o FROM Appointment o WHERE o.doctor.uniqueId = ?1")
    List<Appointment> findByDoctorId(String doctorId);

    @Query("SELECT o FROM Appointment o WHERE o.checkupPart.uniqueId = ?1")
    List<Appointment> findByCheckupPartId(Long checkupPartId);

    @Query("SELECT o FROM Appointment o WHERE o.doctor.uniqueId = ?1 AND o.patient.uniqueId = ?2")
    List<Appointment> findByDoctorIdAndPatientId(String doctorId, String patientId);
}
