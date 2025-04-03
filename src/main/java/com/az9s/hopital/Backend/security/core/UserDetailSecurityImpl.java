package com.az9s.hopital.Backend.security.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.User;
import com.az9s.hopital.Backend.repository.UserRepository;
import com.az9s.hopital.Backend.service.UserDetailSecurity;

@Service
public class UserDetailSecurityImpl implements UserDetailSecurity, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadUserByPhone(username);
    }

    @Override
    public UserDetailsImpl loadUserByPhone(String phone) {
        User user = userRepository.findByPhone(phone)
                        .orElseThrow(() -> new UsernameNotFoundException("User not exist"));

        return new UserDetailsImpl(user);
    }
}
