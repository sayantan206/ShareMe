package com.demo.dao.impl;

import com.demo.dao.UserDao;
import com.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findByUserName(String userEmail) {
        Session session = sessionFactory.getCurrentSession();

        List<User> users = session.createQuery("from User u join fetch u.roles where u.email=:userEmail", User.class)
                .setParameter("userEmail", userEmail)
                .list();

        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }
}
