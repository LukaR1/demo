package com.example.demo.service;

import com.example.demo.domains.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole add(UserRole userRole);

    List<UserRole> get (String userRole);

    UserRole get(int id) throws Exception;

    void delete(int id) throws Exception;

    UserRole update(UserRole userRole) throws Exception;
}
