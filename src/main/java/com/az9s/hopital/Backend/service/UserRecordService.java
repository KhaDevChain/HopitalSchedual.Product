package com.az9s.hopital.Backend.service;

import com.az9s.hopital.Backend.entity.UserRecord;

public interface UserRecordService {
    UserRecord saveUserDetail(UserRecord userDetail);
    UserRecord findById(String id);
    UserRecord findByUserId(String userId);
}
