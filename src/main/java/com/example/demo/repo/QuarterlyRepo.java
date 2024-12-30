package com.example.demo.repo;

import com.example.demo.model.Quarterly;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuarterlyRepo extends JpaRepository<Quarterly,Integer> {
    @Transactional
    List<Quarterly> findByStudentRegisterNo(int studentRegisterNo);
}
