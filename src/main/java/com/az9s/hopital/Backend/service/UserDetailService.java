package com.az9s.hopital.Backend.service;

import com.az9s.hopital.Backend.entity.UserDetail;

public interface UserDetailService {
    UserDetail saveUserDetail(UserDetail userDetail);
    UserDetail findById(String id);
    UserDetail findByUserId(String userId);
}
