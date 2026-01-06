package com.example.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    private List<String> todos = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String task) {
        todos.add(task);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteTodo(@RequestParam int index) {
        todos.remove(index);
        return "redirect:/";
    }
}
