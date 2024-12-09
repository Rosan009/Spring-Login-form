package com.example.demo.repo;

import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Transactional
    List<Student> findByClassName(String className);

    @Transactional
    List<Student> findByRegisterNo(int registerNo);
}
