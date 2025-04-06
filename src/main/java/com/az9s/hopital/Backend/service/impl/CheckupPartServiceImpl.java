package com.az9s.hopital.Backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.CheckupPart;
import com.az9s.hopital.Backend.repository.CheckupPartRepository;
import com.az9s.hopital.Backend.service.CheckupPartService;

@Service
public class CheckupPartServiceImpl implements CheckupPartService {

    @Autowired
    private CheckupPartRepository checkupPartRepository;

    @Override
    public CheckupPart saveCheckupPart(CheckupPart checkupPart) {
        return checkupPartRepository.save(checkupPart);
    }

    @Override
    public CheckupPart findById(Long id) {
        return checkupPartRepository.findById(id).orElse(null);
    }

    @Override
    public CheckupPart findByName(String name) {
        return checkupPartRepository.findByPartName(name).orElse(null);
    }

    @Override
    public List<CheckupPart> findAll() {
        return checkupPartRepository.findAll();
    }
    
}
