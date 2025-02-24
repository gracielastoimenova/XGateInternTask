package com.example.project.service;

import com.example.project.model.Project;
import com.example.project.model.User;

import java.util.List;

public interface ProjectService {

    void updateProject(String project_id, String name, String description);
    void deleteProject(String id);
    Project createNew(String name, String description, Long user_id);

    List<Project> getAllUserProjects(Long user_id);

    Project getProjectById(String id);
}
