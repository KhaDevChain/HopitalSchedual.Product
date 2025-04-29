package com.az9s.hopital.Backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.az9s.hopital.Backend.entity.Pharmacy;

@Repository
public interface PharmacyRespository extends JpaRepository<Pharmacy, String> {
     @Query("SELECT o FROM Pharmacy o WHERE o.user.uniqueId = ?1")
    Optional<Pharmacy> findByUserId(String userId);

    @Query("SELECT o FROM Pharmacy o WHERE o.userRecord.id = ?1")
    Optional<Pharmacy> findByUserRecordId(String userRecordId);

    @Query("SELECT o FROM Pharmacy o WHERE o.taxCode = ?1")
    Optional<Pharmacy> findByTaxCode(String taxCode);
}
