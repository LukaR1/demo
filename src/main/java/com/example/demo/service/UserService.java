package com.example.demo.service;

import com.example.demo.domains.UserDomain;
import com.example.demo.model.Teachers;
import com.example.demo.model.Users;

import java.util.List;

public interface UserService {
    UserDomain add(UserDomain userDomain);

    List<UserDomain> get (String userDomain);

    UserDomain get(int id) throws Exception;

    void delete(int id) throws Exception;

    UserDomain update(UserDomain userDomain) throws Exception;
}
