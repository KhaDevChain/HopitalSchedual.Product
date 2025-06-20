package com.az9s.hopital.Backend.service;

import java.util.List;

import com.az9s.hopital.Backend.entity.Permission;

public interface PermissionService {
    Permission savePermission(Permission permission);
    Permission findById(String id);
    List<Permission> findAll();
}
