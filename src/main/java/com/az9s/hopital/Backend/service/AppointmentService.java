package com.az9s.hopital.Backend.service;

import java.util.List;

import com.az9s.hopital.Backend.entity.Appointment;

public interface AppointmentService {
    Appointment findById(Long id);
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> findAll();
    List<Appointment> findByPatientId(String patientId);
    List<Appointment> findByDoctorId(String doctorId);
    List<Appointment> findByCheckupPartId(Long checkupPartId);
    List<Appointment> findByDoctorIdAndPatientId(String doctorId, String patientId);
}
