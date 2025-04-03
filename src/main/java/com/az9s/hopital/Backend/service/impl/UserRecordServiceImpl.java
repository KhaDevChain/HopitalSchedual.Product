package com.az9s.hopital.Backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.UserRecord;
import com.az9s.hopital.Backend.repository.UserRecordRepository;
import com.az9s.hopital.Backend.service.UserRecordService;

@Service
public class UserRecordServiceImpl implements UserRecordService {
    @Autowired
    private UserRecordRepository userRecordRepository;

    @Override
    public UserRecord saveUserDetail(UserRecord userDetail) {
        return userRecordRepository.save(userDetail);
    }

    @Override
    public UserRecord findById(String id) {
        return userRecordRepository.findById(id).orElse(null);
    }

    @Override
    public UserRecord findByUserId(String userId) {
        return userRecordRepository.findByUserId(userId);
    }

    
}
