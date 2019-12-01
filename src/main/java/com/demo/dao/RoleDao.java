package com.demo.dao;

import com.demo.entity.Role;

public interface RoleDao {
    public Role findRoleByName(String roleName);
}
