package com.example.demo.service;

import com.example.demo.model.StudentSearch;
import com.example.demo.model.Students;
import com.example.demo.model.TeachersAndStudents;

import java.util.List;

public interface TeachersAndStudentsService {
    TeachersAndStudents add (TeachersAndStudents teachersAndStudents);

    List<TeachersAndStudents> get(String TeachersAndStudents);

    TeachersAndStudents get(int id) throws Exception;

    void delete(int id) throws Exception;

    TeachersAndStudents update(TeachersAndStudents teachersAndStudents) throws Exception;

}
