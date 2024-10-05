package com.rocket.rockettest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/task-list")
    public String tasksPage() {
        return "task-list";
    }

    @GetMapping("/new-task")
    public String createTaskPage() {
        return "new-task";
    }
}
