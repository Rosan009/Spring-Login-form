package com.example.demo.repo;

import com.example.demo.model.Annual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnualRepo extends JpaRepository<Annual,Integer> {
}
