package com.az9s.hopital.Backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.Doctor;
import com.az9s.hopital.Backend.repository.DoctorRepository;
import com.az9s.hopital.Backend.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor findById(String id) {
        return doctorRepository.findById(id).orElse(null);
    }
    
}
