package com.az9s.hopital.Backend.service.cache;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.Role;
import com.az9s.hopital.Backend.repository.RoleRepository;
import com.az9s.hopital.Backend.service.RoleService;

@CacheConfig(cacheNames = "role")
@Service("cacheRoleService")
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // Get info from cache
    @Cacheable()
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Cacheable(key = "#id")
    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    // Update or create role and save to cache
    @CachePut(key = "#roleAssign.uniqueId")
    @Override
    public Role saveRole(Role roleAssign) {
        return roleRepository.save(roleAssign);
    }
}
