package com.example.demo.repo;

import com.example.demo.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {

    List<Subject> findByClassList(String classList);
}
