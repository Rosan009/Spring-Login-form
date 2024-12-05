package com.example.demo.service;


import com.example.demo.model.UserLogin;
import com.example.demo.model.UserPrincipal;
import com.example.demo.repo.RepoLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceConfig implements UserDetailsService {

    @Autowired
    private RepoLogin repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin user=repo.findByUsername(username);

        if(user==null)
        {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
    }
}
