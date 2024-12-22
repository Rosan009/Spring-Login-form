package com.example.demo.service;

import com.example.demo.model.UserLogin;
import com.example.demo.repo.RepoLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {
    @Autowired
    private RepoLogin repoLogin;
    private final BCryptPasswordEncoder bCryptPasswordEncode= new BCryptPasswordEncoder(12);
    public UserLogin savaUser(UserLogin user) {
        user.setPassword(bCryptPasswordEncode.encode(user.getPassword()));
       return repoLogin.save(user);
    }
}
