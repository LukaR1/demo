package com.example.demo.service;

import com.example.demo.model.*;


import java.util.List;


public interface StudentsService {
    Students addStudents(Students students);

    List<Students> getStudents(String Student);

    Students get(int id) throws Exception;

    void deleteStudents(int id) throws Exception;

    Students updateStudents(Students students) throws Exception;
}
