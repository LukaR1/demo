package com.example.demo.service;

import com.example.demo.model.*;

import java.util.List;

public interface TeachersService {
    Teachers addTeachers(Teachers teachers);

    List<Teachers> getTeachers(String Teachers);

    Teachers get(int id) throws Exception;

    void deleteTeachers(int id) throws Exception;

    Teachers updateTeachers(Teachers teachers) throws Exception;
}
