package com.az9s.hopital.Backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.Permission;
import com.az9s.hopital.Backend.repository.PermissionRepository;
import com.az9s.hopital.Backend.service.PermissionService;

@Service("logicPermissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission findById(String id) {
        return permissionRepository.findById(id).orElse(null);
    }
}
