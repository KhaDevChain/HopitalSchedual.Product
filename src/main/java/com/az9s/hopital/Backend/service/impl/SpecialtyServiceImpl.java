package com.az9s.hopital.Backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.Specialty;
import com.az9s.hopital.Backend.repository.SpecialtyRepository;
import com.az9s.hopital.Backend.service.SpecialtyService;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Override
    public Specialty saveCheckupPart(Specialty checkupPart) {
        return specialtyRepository.save(checkupPart);
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty findByName(String name) {
        return specialtyRepository.findBySpecialtyName(name).orElse(null);
    }

    @Override
    public List<Specialty> findAll() {
        return specialtyRepository.findAll();
    }
    
}
