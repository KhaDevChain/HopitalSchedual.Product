package com.az9s.hopital.Backend.service;

import com.az9s.hopital.Backend.entity.Doctor;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    Doctor findById(String id);
}
