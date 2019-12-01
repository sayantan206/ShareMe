package com.demo.dao;

import com.demo.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);
}
