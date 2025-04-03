package com.az9s.hopital.Backend.service;

import java.util.List;

import com.az9s.hopital.Backend.entity.Role;

public interface RoleService {
    Role saveRole(Role roleAssign);
    Role findById(Long id);
    List<Role> findAll();
}
