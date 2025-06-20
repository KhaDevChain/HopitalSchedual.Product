package com.az9s.hopital.Backend.service.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.Permission;
import com.az9s.hopital.Backend.repository.PermissionRepository;
import com.az9s.hopital.Backend.service.PermissionService;

@Service("cachePermissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Cacheable()
    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @CachePut(key = "#permission.uniqueId")
    @Override
    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Cacheable(key = "#id")
    @Override
    public Permission findById(String id) {
        return permissionRepository.findById(id).orElse(null);
    }
}
