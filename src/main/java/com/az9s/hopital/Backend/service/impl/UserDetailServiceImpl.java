package com.az9s.hopital.Backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.UserDetail;
import com.az9s.hopital.Backend.repository.UserDetailRepository;
import com.az9s.hopital.Backend.service.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetail saveUserDetail(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    @Override
    public UserDetail findById(String id) {
        return userDetailRepository.findById(id).orElse(null);
    }

    @Override
    public UserDetail findByUserId(String userId) {
        return userDetailRepository.findByUserId(userId);
    }

    
}
