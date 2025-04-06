package com.az9s.hopital.Backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.az9s.hopital.Backend.entity.CheckupPart;

@Repository
public interface CheckupPartRepository extends JpaRepository<CheckupPart, Long> {
    @Query("SELECT o FROM CheckupPart o WHERE o.partName = ?1")
    Optional<CheckupPart> findByPartName(String partName);
}
