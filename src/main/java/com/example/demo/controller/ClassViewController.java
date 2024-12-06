package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("class")
public class ClassViewController {
    @GetMapping("viewclass")
    public String viewClass() {
        return "viewClass";
    }
}
