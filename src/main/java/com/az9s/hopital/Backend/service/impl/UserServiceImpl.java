package com.az9s.hopital.Backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.User;
import com.az9s.hopital.Backend.repository.UserRepository;
import com.az9s.hopital.Backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone).orElse(null);
    }

    @Override
    public Boolean existsByPhone(String phone) {
        User user = this.findByPhone(phone);
        return user != null;
    }
}
