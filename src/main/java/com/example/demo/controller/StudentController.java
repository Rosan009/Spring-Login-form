package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "addStudent")
    public void addStudent(HttpServletRequest request,@RequestParam("profilePhoto") MultipartFile profilePhoto) throws IOException {
        Student student = new Student();
        student.setName(request.getParameter("studentName"));
        student.setClassName(request.getParameter("studentClass"));
        student.setRegisterNo(Integer.parseInt(request.getParameter("regNo")));
        student.setGender(request.getParameter("gender"));
        student.setDataOfBirth(LocalDate.parse(request.getParameter("dob")));
        student.setImageName(profilePhoto.getOriginalFilename());
        student.setImageType(profilePhoto.getContentType());
        student.setImageData(profilePhoto.getBytes());
        studentService.addStudent(student);
    }
    @GetMapping("addStudent")
    public String addStudent() {
        return "addStudent";
    }
    @GetMapping("studentList/{className}")
    public String StudentList(@PathVariable("className") String className,Model model) {
       List<Student> studentList = studentService.getStudentList(className);
       model.addAttribute("students", studentList);
        return "studentList";
    }
    @GetMapping("studentList/{classList}/studentMark/{registerNo}")
    public String StudentMark(@PathVariable("classList") int classList, @PathVariable("registerNo") int registerNo, Model model) {
        List<Subject> studentSubject = studentService.getSubject("Class " + classList);
        model.addAttribute("subjects", studentSubject);
        List<Student> studentDetail = studentService.getDetailStudent(registerNo);
        if (!studentDetail.isEmpty()) {
            Student student = studentDetail.get(0);
            String profilePhotoBase64 = student.getProfilePhotoBase64();
            model.addAttribute("students", studentDetail);
            model.addAttribute("profilePhotoBase64", profilePhotoBase64);
        }
        return "studentMark";
    }


    @GetMapping("studentSubject/{classList}")
    public String StudentSubject(@PathVariable("classList") int classList, Model model) {
        List<Subject> studentSubject = studentService.getSubject("Class "+classList);
        model.addAttribute("subjects", studentSubject);
        System.out.println(studentSubject.size());
        return "studentSubject";
    }

}
