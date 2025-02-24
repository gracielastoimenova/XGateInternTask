package com.example.project.web;

import com.example.project.model.Project;
import com.example.project.service.ProjectService;
import com.example.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/main/{userId}")
public class ProjectController {

    private final UserService userService;
    private final ProjectService projectService;


    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }


    @GetMapping()
    public String viewMain(@PathVariable String userId,
                           Model model){
        model.addAttribute("projects", projectService.getAllUserProjects(userService.getCurrentUser().getId()));
        model.addAttribute("userId", userId);
        return "main";
    }


    @GetMapping("/new")
    public String getCreateProjectForm(@PathVariable String userId,
                                       Model model) {
        model.addAttribute("userId", userId);
        return "createProject";
    }

    @PostMapping("/new")
    public String createNewProject(@PathVariable String userId,
                                   @RequestParam String name,
                                   @RequestParam String description,
                                   RedirectAttributes redirectAttributes) {
        Project project = projectService.createNew(name, description, Long.parseLong(userId));
        if (project == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "The name is already taken. Please choose another one.");
            return "redirect:/main/{userId}/new";
        } else {
            return "redirect:/main/" + userId;
        }
    }


    @GetMapping("/{projectId}/update")
    public String getUpdateProjectForm(@PathVariable String projectId,
                                       @PathVariable String userId,
                                       Model model){
        model.addAttribute("projectId", projectId);
        model.addAttribute("userId", userId);

        Project project = projectService.getProjectById(projectId);
        model.addAttribute("name", project.getName());
        model.addAttribute("description", project.getDescription());

        return "updateProject";
    }

    @PostMapping("/{projectId}/update")
    public String updateProject(@PathVariable String projectId,
                                @RequestParam String name,
                                @RequestParam String description){
        System.out.println("update project post");
        projectService.updateProject(projectId, name, description);
        return "redirect:/main/{userId}";
    }

    @PostMapping("/{projectId}/delete")
    public String deleteProject(@PathVariable String projectId){
        projectService.deleteProject(projectId);
        return "redirect:/main/{userId}";
    }

}
