package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repo.AnnualRepo;
import com.example.demo.repo.ExamRepo;
import com.example.demo.repo.HalfYearlyRepo;
import com.example.demo.repo.QuarterlyRepo;
import com.example.demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private QuarterlyRepo quarterlyRepo;
    @Autowired
    private HalfYearlyRepo halfYearlyRepo;
    @Autowired
    private AnnualRepo annualRepo;
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
        List<Subject> studentSubject = studentService.getSubject("class"+classList);
        model.addAttribute("subjects", studentSubject);
        List<Student> studentDetail = studentService.getDetailStudent(registerNo);
        if (!studentDetail.isEmpty()) {
            Student student = studentDetail.get(0);
            String profilePhotoBase64 = student.getProfilePhotoBase64();
            model.addAttribute("students", studentDetail);
            model.addAttribute("profilePhotoBase64", profilePhotoBase64);
        }
        List<Exam>exam=examRepo.findByClassList("class" + classList);
        Exam e=exam.get(0);
        List<String> arr =e.getExamNames();
        model.addAttribute("exams",arr);
        return "studentMark";
    }
    @Transactional
    @PostMapping("studentList/{classList}/studentMark/{registerNo}")
    public String StudentMarkList(@PathVariable("classList") int classList, @PathVariable("registerNo") int registerNo, HttpServletRequest request) {
        // Fetch the subjects and student details based on class and register number
        List<Subject> studentSubject = studentService.getSubject("class" + classList);
        List<Student> studentDetail = studentService.getDetailStudent(registerNo);
        Student student = studentDetail.get(0); // Assuming we get the first student from the list

        // Create a list to hold the subject marks
        List<SubjectMarks> subjectMarksList = new ArrayList<>();

        // Assuming there are 5 subjects, get marks for each
        for (int i = 1; i <= 5; i++) {
            String subjectName = null;
            int subjectMark = 0;

            // Get the subject name and mark based on the subject number
            switch (i) {
                case 1:
                    subjectName = studentSubject.get(0).getSubject1();
                    break;
                case 2:
                    subjectName = studentSubject.get(0).getSubject2();
                    break;
                case 3:
                    subjectName = studentSubject.get(0).getSubject3();
                    break;
                case 4:
                    subjectName = studentSubject.get(0).getSubject4();
                    break;
                case 5:
                    subjectName = studentSubject.get(0).getSubject5();
                    break;
            }

            // Get the subject mark from the request
            subjectMark = Integer.parseInt(request.getParameter("subject" + i));

            // Add the subject and marks to the list
            subjectMarksList.add(new SubjectMarks(subjectName, subjectMark));
        }

        // Get the exam type (Quarterly, Half-Yearly, Annual) from the request
        List<Exam> studentExam = examRepo.findByClassList("class"+ classList);
        Exam exam = studentExam.get(0);
        String examType=request.getParameter("studentExam");

        int totalMarks = subjectMarksList.stream().mapToInt(SubjectMarks::getMark).sum(); // Calculate total marks

        // Create and save the appropriate exam entity (Quarterly, Half-Yearly, or Annual)
        if ("Quarterly".equals(examType)) {
            Quarterly quarterly = new Quarterly();
            quarterly.setStudentName(student.getName());
            quarterly.setStudentRegisterNo(student.getRegisterNo());
            quarterly.setStudentClass(student.getClassName());
            quarterly.setSubjectMarks(subjectMarksList);
            quarterly.calculateTotalMark();
            quarterlyRepo.save(quarterly);
        } else if ("Half-Yearly".equals(examType)) {
            HalfYearly halfYearly = new HalfYearly();
            halfYearly.setStudentName(student.getName());
            halfYearly.setStudentRegisterNo(student.getRegisterNo());
            halfYearly.setStudentClass(student.getClassName());
            halfYearly.setSubjectMarks(subjectMarksList);
            halfYearly.calculateTotalMark();
            halfYearlyRepo.save(halfYearly);
        } else if ("Annual".equals(examType)) {
            Annual annual = new Annual();
            annual.setStudentName(student.getName());
            annual.setStudentRegisterNo(student.getRegisterNo());
            annual.setStudentClass(student.getClassName());
            annual.setSubjectMarks(subjectMarksList);
            annual.calculateTotalMark();
            annualRepo.save(annual);
        }
        System.out.println("Student Name: " + student.getName());
        System.out.println("Exam Type: " + examType);
        System.out.println("Subject Marks: " + subjectMarksList);
        return "redirect:/home";
    }

    @GetMapping("studentSubject/{classList}")
    public String StudentSubject(@PathVariable("classList") int classList, Model model) {
        List<Subject> studentSubject = studentService.getSubject("class"+classList);
        model.addAttribute("subjects", studentSubject);
        System.out.println(studentSubject.size());
        return "studentSubject";
    }
    @GetMapping("studentList/{classList}/viewMark/{registerNo}")
    public String viewMarks(@PathVariable("classList") int classList,
                            @PathVariable("registerNo") int regNo,
                            @RequestParam(value = "examtype", required = false) String examType,
                            Model model) {

        // Get the list of exams for the class
        List<Exam> exams = examRepo.findByClassList("class" + classList);
        if (!exams.isEmpty()) {
            Exam e = exams.get(0);
            model.addAttribute("exams", e.getExamNames());
        } else {
            model.addAttribute("exams", new ArrayList<>()); // No exams found
        }

        // Get student details
        List<Student> studentDetails = studentService.getDetailStudent(regNo);
        if (!studentDetails.isEmpty()) {
            model.addAttribute("student", studentDetails.get(0));
        } else {
            model.addAttribute("student", null);
            System.out.println("No student found with register number: " + regNo);
        }

        // Fetch marks and total for the selected exam type
        List<SubjectMarks> marks = null;
        Integer totalMark = null;
        if ("Half-Yearly".equalsIgnoreCase(examType)) {
            List<HalfYearly> halfYearlyList = halfYearlyRepo.findByStudentRegisterNo(regNo);
            if (!halfYearlyList.isEmpty()) {
                HalfYearly halfYearly = halfYearlyList.get(0);
                marks = halfYearly.getSubjectMarks();
                totalMark = halfYearly.getTotalMark();
            }
        } else if ("Quarterly".equalsIgnoreCase(examType)) {
            List<Quarterly> quarterlyList = quarterlyRepo.findByStudentRegisterNo(regNo);
            if (!quarterlyList.isEmpty()) {
                Quarterly quarterly = quarterlyList.get(0);
                marks = quarterly.getSubjectMarks();
                totalMark = quarterly.getTotalMark();
            }
        } else if ("Annual".equalsIgnoreCase(examType)) {
            List<Annual> annualList = annualRepo.findByStudentRegisterNo(regNo);
            if (!annualList.isEmpty()) {
                Annual annual = annualList.get(0);
                marks = annual.getSubjectMarks();
                totalMark = annual.getTotalMark();
            }
        }

        // If no marks found, add null to the model
        if (marks == null) {
            model.addAttribute("marks", new ArrayList<>()); // Empty list for frontend handling
            model.addAttribute("noMarksMessage", "No marks available for the selected exam type.");
            model.addAttribute("totalMark", null);
        } else {
            model.addAttribute("marks", marks);
            model.addAttribute("totalMark", totalMark);
            model.addAttribute("noMarksMessage", null);
        }

        return "viewMark";
    }

    @GetMapping("examList/{classList}")
    public String examList(@PathVariable("classList") int classList, Model model){
        List<Exam> exam=examRepo.findByClassList("class"+classList);
        model.addAttribute("exams",exam);
        return "examList";
    }
}
