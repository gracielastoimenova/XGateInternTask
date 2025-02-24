package com.example.project.service.impl;

import com.example.project.model.Project;
import com.example.project.repository.ProjectRepository;
import com.example.project.service.ProjectService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void updateProject(String project_id, String name, String description) {
        Project project = projectRepository.getProjectsById(Long.parseLong(project_id));
        project.setName(name);
        project.setDescription(description);
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(String id) {
        projectRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Project createNew(String name, String description, Long user_id) {
        try{
           return projectRepository.save(new Project(name, description, user_id));
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Project> getAllUserProjects(Long user_id) {
        return projectRepository.getAllByUserId(user_id);
    }

    @Override
    public Project getProjectById(String id) {
        return projectRepository.getProjectsById(Long.parseLong(id));
    }
}
