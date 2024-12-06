package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {

    @GetMapping("addStudent")
    public String addStudent() {
        return "addStudent";
    }
    @GetMapping("studentList")
    public String StudentList() {
        return "studentList";
    }
    @GetMapping("studentList/studentMark")
    public String StudentMark() {
        return "studentMark";
    }
    @GetMapping("studentSubject")
    public String StudentSubject() {
        return "studentSubject";
    }

}
