package com.az9s.hopital.Backend.service;

import java.util.List;

import com.az9s.hopital.Backend.entity.Department;

public interface DepartmentService {
    Department save(Department department);
    Department findById(Long id);
    void deleteById(Long id);
    void delete(Department department);
    boolean existsById(Long id);
    List<Department> findAll();
    List<Department> findByNameContaining(String name);
}
