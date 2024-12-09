package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.repo.StudentRepo;
import com.example.demo.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    public void addStudent(Student student) {
        studentRepo.save(student);
    }


    public List<Student> getStudentList(String className) {
        return studentRepo.findByClassName(className);
    }


    public List<Subject> getSubject(String classList) {
        return subjectRepo.findByClassList(classList);
    }

    public List<Student> getDetailStudent(int registerNo) {
        return studentRepo.findByRegisterNo(registerNo);
    }
}
