package com.example.demo.controller;

import com.example.demo.model.Exam;
import com.example.demo.model.Mark;
import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.repo.ExamRepo;
import com.example.demo.repo.MarkRepo;
import com.example.demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private MarkRepo markRepo;
    @Autowired
    private ExamRepo examRepo;
    @PostMapping(value = "addStudent")
    public String addStudent(HttpServletRequest request,@RequestParam("profilePhoto") MultipartFile profilePhoto) throws IOException {
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
        return "redirect:/home";
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
        List<Exam>exam=examRepo.findByClassList("Class " + classList);
        Exam e=exam.get(0);
        List<String> arr =e.getExamNames();
        model.addAttribute("exams",arr);
        return "studentMark";
    }
    @PostMapping("studentList/{classList}/studentMark/{registerNo}")
    public String StudentMarkList(@PathVariable("classList") int classList, @PathVariable("registerNo") int registerNo,HttpServletRequest request){
        List<Subject> studentSubject = studentService.getSubject("Class " + classList);
        List<Student> studentDetail = studentService.getDetailStudent(registerNo);
        Student student = studentDetail.get(0);
        Subject subject=studentSubject.get(0);
        Mark mark=new Mark();
        HashMap<String,Integer> map = new HashMap<>();
        map.put(subject.getSubject1(), Integer.valueOf(request.getParameter("subject1")));
        map.put(subject.getSubject2(), Integer.valueOf(request.getParameter("subject2")));
        map.put(subject.getSubject3(), Integer.valueOf(request.getParameter("subject3")));
        map.put(subject.getSubject4(), Integer.valueOf(request.getParameter("subject4")));
        map.put(subject.getSubject5(), Integer.valueOf(request.getParameter("subject5")));
        mark.setStudentName(student.getName());
        mark.setStudentRegisterNo(student.getRegisterNo());
        mark.setSubjectMarks(map);
        mark.setStudent(student);
        Exam exam=new Exam();
        for(String val: exam.getExamNames())
        {
            if (String.valueOf(request.getParameter("exam")).equals(val))
            {
                String examType = request.getParameter("exam");
                int examMark=(Integer.parseInt(request.getParameter("subject1"))
                +Integer.parseInt(request.getParameter("subject2"))
                +Integer.parseInt(request.getParameter("subject3"))
                +Integer.parseInt(request.getParameter("subject4"))
                +Integer.parseInt(request.getParameter("subject5")));
                if ("Quarterly Exam".equals(examType)) {
                    mark.setQuarterly(examMark);
                } else if ("Half-Yearly Exam".equals(examType)) {
                    mark.setHalfYearly(examMark);
                } else if ("Annual Exam".equals(examType)) {
                    mark.setAnnual(examMark);
                }
                System.out.println("total value ="+examMark);
            }
        }
        studentService.addMark(student);

        markRepo.save(mark);

        return "redirect:/home";
    }

    @GetMapping("studentSubject/{classList}")
    public String StudentSubject(@PathVariable("classList") int classList, Model model) {
        List<Subject> studentSubject = studentService.getSubject("Class "+classList);
        model.addAttribute("subjects", studentSubject);
        System.out.println(studentSubject.size());
        return "studentSubject";
    }

    @GetMapping("examList/{classList}")
    public String examList(@PathVariable("classList") int classList, Model model){
        List<Exam> exam=examRepo.findByClassList("Class "+ classList);
        model.addAttribute("exams",exam);
        return "examList";
    }
}
