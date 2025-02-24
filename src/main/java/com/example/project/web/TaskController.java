package com.example.project.web;

import com.example.project.model.Task;
import com.example.project.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/main/{userId}/{projectId}/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/new")
    public String getCreateTaskForm(@PathVariable String userId,
                                    @PathVariable String projectId,
                                    Model model){
        model.addAttribute("userId", userId);
        model.addAttribute("projectId", projectId);
        return "createTask";
    }

    @PostMapping("/new")
    public String createTask(@PathVariable String projectId,
                             @RequestParam String title,
                             @RequestParam String description,
                             @RequestParam(required = false) String dueDate){
        if (dueDate.isEmpty()){
            taskService.createTask(title, description, Long.parseLong(projectId));
        }else taskService.createTask(title, description, LocalDate.parse(dueDate), Long.parseLong(projectId));

        return "redirect:/main/{userId}";
    }

    @GetMapping("/{taskId}/update")
    public String getUpdateTaskForm(@PathVariable String userId,
                                    @PathVariable String projectId,
                                    @PathVariable String taskId,
                                    Model model){
        model.addAttribute("userId", userId);
        model.addAttribute("projectId", projectId);
        model.addAttribute("taskId", taskId);

        Task task = taskService.getTaskById(taskId);
        model.addAttribute("title", task.getTitle());
        model.addAttribute("description", task.getDescription());
        model.addAttribute("dueDate", task.getDueDate());

        return "updateTask";
    }

    @PostMapping("/{taskId}/update")
    public String updateTask(@PathVariable String taskId,
                             @RequestParam String title,
                             @RequestParam String description,
                             @RequestParam String dueDate) {
        taskService.updateTask(taskId, title, description, LocalDate.parse(dueDate));
        return "redirect:/main/{userId}";
    }

    @PostMapping("/{taskId}/delete")
    public String deleteTask(@PathVariable String taskId){
        taskService.deleteTask(taskId);
        return "redirect:/main/{userId}";
    }

}
