package com.az9s.hopital.Backend.service;

import java.util.List;

import com.az9s.hopital.Backend.entity.TaskNote;
import com.az9s.hopital.Backend.utils.option.TaskEnum;

public interface TaskNoteService {
    void deleteTaskNote(Long id);
    TaskNote saveTaskNote(TaskNote taskNote);
    List<TaskNote> findAll();
    List<TaskNote> findByStatus(TaskEnum status);
}
