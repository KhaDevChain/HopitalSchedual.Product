package com.az9s.hopital.Backend.service.cache;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.CheckupPart;
import com.az9s.hopital.Backend.repository.CheckupPartRepository;
import com.az9s.hopital.Backend.service.CheckupPartService;

@CacheConfig(cacheNames = "checkupPart")
@Service("cacheCheckPartService")
public class CheckPartServiceImpl implements CheckupPartService {

    private final CheckupPartRepository checkupPartRepository;

    public CheckPartServiceImpl(CheckupPartRepository checkupPartService) {
        this.checkupPartRepository = checkupPartService;
    }

    @CachePut(key = "#checkupPart.uniqueId")
    @Override
    public CheckupPart saveCheckupPart(CheckupPart checkupPart) {
        return checkupPartRepository.save(checkupPart);
    }


    // Get Info from cache

    @Cacheable(key = "#id")
    @Override
    public CheckupPart findById(Long id) {
        return checkupPartRepository.findById(id).orElse(null);
    }

    @Cacheable(key = "#name")
    @Override
    public CheckupPart findByName(String name) {
        return checkupPartRepository.findByPartName(name).orElse(null);
    }

    @Cacheable
    @Override
    public List<CheckupPart> findAll() {
        return checkupPartRepository.findAll();
    }
    
}
