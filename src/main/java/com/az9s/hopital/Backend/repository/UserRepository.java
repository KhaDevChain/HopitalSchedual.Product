package com.az9s.hopital.Backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.az9s.hopital.Backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT o FROM User o WHERE o.phone = ?1")
    Optional<User> findByPhone(String phone);

    @Query("SELECT o FROM User o WHERE o.email = ?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT o FROM User o WHERE o.email = ?1 OR o.phone = ?1")
    Optional<User> findByEmailOrPhone(String emailOrPhone);

    @Query("SELECT o FROM User o WHERE o.phone = ?1 AND o.role.uniqueId = ?2")
    List<User> findByPhoneAndRole(String phone, String roleId);
}
