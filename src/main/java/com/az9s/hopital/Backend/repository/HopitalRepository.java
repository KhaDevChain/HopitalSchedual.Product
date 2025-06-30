package com.az9s.hopital.Backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.az9s.hopital.Backend.entity.Hopital;

@Repository
public interface HopitalRepository extends JpaRepository<Hopital, String> {
    Optional<Hopital> findByTaxCode(String taxCode);
    List<Hopital> findByContractIsNotNullAndContractNot(String empty);
}
