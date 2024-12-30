package com.example.demo.repo;

import com.example.demo.model.HalfYearly;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HalfYearlyRepo extends JpaRepository<HalfYearly,Integer> {
    @Transactional
    List<HalfYearly> findByStudentRegisterNo(int studentRegisterNo);
}
