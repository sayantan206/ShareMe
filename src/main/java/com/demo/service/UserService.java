package com.demo.service;

import com.demo.entity.NewUser;
import com.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;

public interface UserService extends UserDetailsService{
    User findByUserName(String userName);

    void save(NewUser newUser);

    public User getCurrentUser(HttpServletRequest request);
}
