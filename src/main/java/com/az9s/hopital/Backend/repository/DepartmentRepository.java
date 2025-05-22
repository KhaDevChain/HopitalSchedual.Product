package com.az9s.hopital.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.az9s.hopital.Backend.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
