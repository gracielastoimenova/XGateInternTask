package com.example.project.web;

import com.example.project.model.User;
import com.example.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class AuthenticationController {
    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String viewLoginPage(){
        return "login";
    }

    @GetMapping ("/signin")
    public String viewSigninPage(){
        return "signin";
    }

    @PostMapping("/signin")
    public String signin(@RequestParam String email,
                         @RequestParam String name,
                         @RequestParam String password,
                         Model model) {
        User user = userService.saveUser(name, email, password);
        if (user == null) {
            model.addAttribute("errorMessage", "Email is already taken. Please choose another one.");
            return "signin";
        }
        return "redirect:/login";
    }

}
