package com.az9s.hopital.Backend.service.cache;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.Hopital;
import com.az9s.hopital.Backend.repository.HopitalRepository;
import com.az9s.hopital.Backend.service.HopitalService;

@CacheConfig(cacheNames = "hopital")
@Service("cacheHopitalService")
public class HopitalServiceImpl implements HopitalService {
    
    private final HopitalRepository hopitalRepository;

    public HopitalServiceImpl(HopitalRepository hopitalRepository) {
        this.hopitalRepository = hopitalRepository;
    }

    @Cacheable(key = "#id")
    @Override
    public Hopital findById(String id) {
        return hopitalRepository.findById(id).orElse(null);
    }

    @CachePut(key = "#hopital.uniqueId")
    @Override
    public Hopital saveHopital(Hopital hopital) {
        return hopitalRepository.save(hopital);
    }

    @Cacheable()
    @Override
    public List<Hopital> findAll() {
        return hopitalRepository.findAll();
    }

    @CacheEvict(key = "#id")
    @Override
    public void deleteById(String id) {
        hopitalRepository.deleteById(id);
    }
    
}
