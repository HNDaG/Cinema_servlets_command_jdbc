package com.hohulia.cinema.dao.interfaces;

import com.hohulia.cinema.entities.UserRole;

import java.util.List;

public interface UserRoleInterface {
    UserRole findRoleByUserId(long id);
    List<UserRole> findByRoleId(long role);
    List<UserRole> findAll();
    void deleteById(long id);
    void addUserRole (UserRole userRole);
    void updateByUserId(long id, int roleId);


}
