package com.az9s.hopital.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.az9s.hopital.Backend.entity.UserRecord;

@Repository
public interface UserRecordRepository extends JpaRepository<UserRecord, String> {
    @Query("SELECT o FROM UserRecord o WHERE o.user.uniqueId = ?1")
    UserRecord findByUserId(String userId);
}
