package com.example.demo.repo;

import com.example.demo.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoLogin extends JpaRepository<UserLogin, Integer> {

    UserLogin findByUsername(String username);
}
