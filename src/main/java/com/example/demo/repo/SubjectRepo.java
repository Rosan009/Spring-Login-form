package com.example.demo.repo;

import com.example.demo.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer> {

    List<Subject> findByClassList(String classList);
}

