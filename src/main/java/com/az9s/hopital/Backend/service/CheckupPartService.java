package com.az9s.hopital.Backend.service;

import java.util.List;

import com.az9s.hopital.Backend.entity.CheckupPart;

public interface CheckupPartService {
    CheckupPart saveCheckupPart(CheckupPart checkupPart);
    CheckupPart findById(Long id);
    CheckupPart findByName(String name);
    List<CheckupPart> findAll();
}
