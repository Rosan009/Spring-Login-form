package com.example.demo.repo;

import com.example.demo.model.Annual;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnualRepo extends JpaRepository<Annual,Integer> {
    @Transactional
    List<Annual> findByStudentRegisterNo(int studentRegisterNo);
}
