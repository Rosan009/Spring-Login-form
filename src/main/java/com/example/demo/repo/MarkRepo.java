package com.example.demo.repo;

import com.example.demo.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepo extends JpaRepository<Mark, Long> {
}
