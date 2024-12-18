package com.example.demo.repo;


import com.example.demo.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepo extends JpaRepository<Exam,Integer> {
    List<Exam> findByClassList(String classList);
}
