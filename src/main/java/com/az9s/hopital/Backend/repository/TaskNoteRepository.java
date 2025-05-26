package com.az9s.hopital.Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.az9s.hopital.Backend.entity.TaskNote;
import com.az9s.hopital.Backend.utils.option.TaskEnum;

@Repository
public interface TaskNoteRepository extends JpaRepository<TaskNote, Long> {
    List<TaskNote> findByStatus(TaskEnum status);
}
