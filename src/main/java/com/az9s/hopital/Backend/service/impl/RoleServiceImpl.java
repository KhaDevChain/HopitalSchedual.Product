package com.az9s.hopital.Backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.Role;
import com.az9s.hopital.Backend.repository.RoleRepository;
import com.az9s.hopital.Backend.service.RoleService;

@Service("logicRoleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role roleAssign) {
        return roleRepository.save(roleAssign);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
