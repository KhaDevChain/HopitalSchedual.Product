package com.az9s.hopital.Backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.Patient;
import com.az9s.hopital.Backend.repository.PatientRepository;
import com.az9s.hopital.Backend.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(String id) {
        return patientRepository.findById(id).orElse(null);
    }
    
}
