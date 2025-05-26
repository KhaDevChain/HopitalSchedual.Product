package com.az9s.hopital.Backend.service.cache;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.az9s.hopital.Backend.entity.TaskNote;
import com.az9s.hopital.Backend.repository.TaskNoteRepository;
import com.az9s.hopital.Backend.service.TaskNoteService;
import com.az9s.hopital.Backend.utils.option.TaskEnum;

@CacheConfig(cacheNames = "taskNote")
@Service("cacheTaskNoteService")
public class TaskNoteServiceImpl implements TaskNoteService {

    private final TaskNoteRepository taskNoteRepository;

    public TaskNoteServiceImpl(TaskNoteRepository taskNoteRepository) {
        this.taskNoteRepository = taskNoteRepository;
    }

    @CachePut(key = "#taskNote.uniqueId")
    @Override
    public TaskNote saveTaskNote(TaskNote taskNote) {
        return taskNoteRepository.save(taskNote);
    }

    @CacheEvict(key = "#id")
    @Override
    public void deleteTaskNote(Long id) {
        taskNoteRepository.deleteById(id);
    }

    @Cacheable()
    @Override
    public List<TaskNote> findAll() {
        return taskNoteRepository.findAll();
    }

    @Cacheable(key = "#status")
    @Override
    public List<TaskNote> findByStatus(TaskEnum status) {
        return taskNoteRepository.findByStatus(status);
    }
    
}
