package com.example.demo.repo;

import com.example.demo.model.HalfYearly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HalfYearlyRepo extends JpaRepository<HalfYearly,Integer> {
}
