package com.example.project.service.impl;

import com.example.project.model.Task;
import com.example.project.repository.TaskRepository;
import com.example.project.service.TaskService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String title, String description, LocalDate dueDate, Long projectId) {
       try {
           return taskRepository.save(new Task(title, description, dueDate, projectId));
       }catch (DataIntegrityViolationException e){
           return null;
       }
    }

    @Override
    public Task createTask(String title, String description, Long projectId) {
        try {
            return taskRepository.save(new Task(title, description, projectId));
        }catch (DataIntegrityViolationException e){
            return null;
        }
    }

    @Override
    public Task getTaskById(String taskId) {
        return taskRepository.getTaskById(Long.parseLong(taskId));
    }

    @Override
    public Task updateTask(String taskId, String title, String description, LocalDate dueDate) {
        Task task = taskRepository.getTaskById(Long.parseLong(taskId));
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(String taskId) {
       taskRepository.delete(taskRepository.getTaskById(Long.parseLong(taskId)));
    }
}
