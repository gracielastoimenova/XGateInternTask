package com.example.project.service;

import com.example.project.model.Task;

import java.time.LocalDate;

public interface TaskService {

    Task createTask(String title, String description, LocalDate dueDate, Long projectId);
    Task createTask(String title, String description, Long projectId);

    Task getTaskById(String taskId);
    Task updateTask(String taskId, String title, String description, LocalDate dueDate);
    void deleteTask(String taskId);
}
