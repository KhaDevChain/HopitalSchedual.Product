package com.az9s.hopital.Backend.utils.http.response;

import java.time.LocalDateTime;

import com.az9s.hopital.Backend.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {
    private String message;
    private Department department;
    private LocalDateTime createdAt;

    public DepartmentResponse(String message, Department department) {
        this.message = message;
        this.department = department;
        this.createdAt = LocalDateTime.now();
    }
}
