package com.example.demo.repo;

import com.example.demo.model.Quarterly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuarterlyRepo extends JpaRepository<Quarterly,Integer> {
}
