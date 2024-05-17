package com.alexey.springboot.SpringBootProject.controller;

import com.alexey.springboot.SpringBootProject.model.User;
import com.alexey.springboot.SpringBootProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "users";
    }

    @GetMapping("/addForm")
    public String addForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "info";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @PutMapping("/editForm")
    public String editForm(@RequestParam("userId") Long id, Model model) {
        User user = userService.update(id);
        model.addAttribute("user", user);
        return "info";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}