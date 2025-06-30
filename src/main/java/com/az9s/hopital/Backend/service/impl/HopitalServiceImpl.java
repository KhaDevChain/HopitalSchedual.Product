package com.az9s.hopital.Backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.Hopital;
import com.az9s.hopital.Backend.repository.HopitalRepository;
import com.az9s.hopital.Backend.service.HopitalService;

@Service("logicHopitalService")
public class HopitalServiceImpl implements HopitalService {
    
    private final HopitalRepository hopitalRepository;

    public HopitalServiceImpl(HopitalRepository hopitalRepository) {
        this.hopitalRepository = hopitalRepository;
    }

    @Override
    public Hopital findById(String id) {
        return hopitalRepository.findById(id).orElse(null);
    }

    @Override
    public Hopital saveHopital(Hopital hopital) {
        return hopitalRepository.save(hopital);
    }

    @Override
    public List<Hopital> findAll() {
        return hopitalRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        hopitalRepository.deleteById(id);
    }

    @Override
    public List<Hopital> findByContractIsNotNullAndContractNot() {
        return hopitalRepository.findByContractIsNotNullAndContractNot("");
    }
}
