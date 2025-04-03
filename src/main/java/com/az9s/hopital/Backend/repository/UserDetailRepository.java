package com.az9s.hopital.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.az9s.hopital.Backend.entity.UserDetail;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, String> {
    @Query("SELECT o FROM UserDetail o WHERE o.user.uniqueId = ?1")
    UserDetail findByUserId(String userId);
}
