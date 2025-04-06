package com.az9s.hopital.Backend.service;

import java.util.List;

import com.az9s.hopital.Backend.entity.Specialty;

public interface SpecialtyService {
    Specialty saveCheckupPart(Specialty checkupPart);
    Specialty findById(Long id);
    Specialty findByName(String name);
    List<Specialty> findAll(); 
}
