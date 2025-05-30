package com.az9s.hopital.Backend.service;

import java.util.List;

import com.az9s.hopital.Backend.entity.Hopital;

public interface HopitalService {
    Hopital findById(String id);
    Hopital saveHopital(Hopital hopital);
    List<Hopital> findAll();
    void deleteById(String id);
}
