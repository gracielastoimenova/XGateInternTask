package com.example.project.repository;

import com.example.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository  extends JpaRepository<Project, Long> {

    Project getProjectsById(Long id);
    void deleteById(Long id);
    List<Project> getAllByUserId(Long user_id);
}
