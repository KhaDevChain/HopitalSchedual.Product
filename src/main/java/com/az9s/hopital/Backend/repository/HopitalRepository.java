package com.az9s.hopital.Backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.az9s.hopital.Backend.entity.Hopital;

public interface HopitalRepository extends JpaRepository<Hopital, String> {
    Optional<Hopital> findByTaxCode(String taxCode);
}
