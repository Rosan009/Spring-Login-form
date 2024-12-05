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

    public List<UserLogin> findAllDetail() {
       return repoLogin.findAll();
    }

    public void updateUser(int id, String username, String email) {
        UserLogin user = repoLogin.findById(id).get();
        user.setUsername(username);
        user.setEmail(email);
        repoLogin.save(user);
    }

    public void deleteData(int id) {
        repoLogin.deleteById(id);
    }
}
