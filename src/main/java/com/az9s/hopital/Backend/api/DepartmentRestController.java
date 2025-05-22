package com.az9s.hopital.Backend.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az9s.hopital.Backend.entity.Department;
import com.az9s.hopital.Backend.service.DepartmentService;
import com.az9s.hopital.Backend.utils.http.request.DepartmentRequest;
import com.az9s.hopital.Backend.utils.http.response.DepartmentResponse;
import com.az9s.hopital.Backend.utils.option.ActivateEnum;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/department")
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<?> login(@RequestBody DepartmentRequest departmentRequest) {

        Department department = new Department();
        department.setDepartmentName(departmentRequest.getDepartmentName());
        department.setNote(departmentRequest.getNote());
        department.setActivated(ActivateEnum.ACTIVE);
        department.setCreatedAt(LocalDateTime.now());
        Department departmentSaved = departmentService.save(department);
        return ResponseEntity.ok(new DepartmentResponse("Save new department successfully", departmentSaved));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Long id) {
        if (id != null && departmentService.existsById(id)) {
            departmentService.deleteById(id);
            return ResponseEntity.ok("Delete department successfully");
        } else {
            return ResponseEntity.badRequest().body("Department not found");
        }
    }
}
