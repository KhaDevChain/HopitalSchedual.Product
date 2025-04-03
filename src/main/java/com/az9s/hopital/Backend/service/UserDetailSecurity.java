package com.az9s.hopital.Backend.service;

import com.az9s.hopital.Backend.security.core.UserDetailsImpl;

public interface UserDetailSecurity {
    UserDetailsImpl loadUserByPhone(String phone);
}
