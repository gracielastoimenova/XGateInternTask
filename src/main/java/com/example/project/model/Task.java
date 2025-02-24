package com.example.project.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    private LocalDate dueDate;
    @Column(nullable = false)
    private long project_id;

    public Task() {
    }

    public Task(String title, String description, long project_id) {
        this.title = title;
        this.description = description;
        this.project_id = project_id;
    }

    public Task(String title, String description, LocalDate dueDate, long project_id) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.project_id = project_id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }
}
