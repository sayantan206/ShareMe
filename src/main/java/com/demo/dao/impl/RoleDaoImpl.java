package com.demo.dao.impl;

import com.demo.dao.RoleDao;
import com.demo.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findRoleByName(String roleName) {
        Session session = sessionFactory.getCurrentSession();

        List<Role> roles = session.createQuery("from Role where name=:roleName", Role.class)
                .setParameter("roleName", roleName)
                .list();

        return roles.isEmpty() ? null : roles.get(0);
    }
}
