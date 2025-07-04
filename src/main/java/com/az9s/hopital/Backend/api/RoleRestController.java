package com.az9s.hopital.Backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az9s.hopital.Backend.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleRestController {
    @Autowired
    @Qualifier("logicRoleService")
    private RoleService roleService;
    
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }
}
