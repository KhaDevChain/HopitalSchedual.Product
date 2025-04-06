package com.az9s.hopital.Backend.service;

import com.az9s.hopital.Backend.entity.Patient;

public interface PatientService {
    Patient savePatient(Patient patient);
    Patient findById(String id);
}
