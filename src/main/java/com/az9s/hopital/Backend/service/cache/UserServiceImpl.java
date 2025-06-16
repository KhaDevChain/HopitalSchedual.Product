package com.az9s.hopital.Backend.service.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.User;
import com.az9s.hopital.Backend.repository.UserRepository;
import com.az9s.hopital.Backend.service.UserService;

@CacheConfig(cacheNames = "user")
@Service("cacheUserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @CachePut(key = "#user.uniqueId")
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Cacheable(key = "#id")
    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Cacheable(key = "#email")
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Cacheable(key = "#phone")
    @Override
    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone).orElse(null);
    }

    @Cacheable()
    @Override
    public Boolean existsByPhone(String phone) {
        User user = this.findByPhone(phone);
        return user != null;
    }
}
