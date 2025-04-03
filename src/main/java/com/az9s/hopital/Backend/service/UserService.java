package com.az9s.hopital.Backend.service;

import com.az9s.hopital.Backend.entity.User;

public interface UserService {
    User saveUser(User user);
    User findById(String id);
    User findByEmail(String email);
    User findByPhone(String phone);
    Boolean existsByPhone(String phone);
}
