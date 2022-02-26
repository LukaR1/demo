package com.example.demo.service;

import com.example.demo.model.*;


import java.util.List;


public interface ClassService {
    Student addStudent (Student student);
    List <Student> getStudent (String Student);

    Student get(int id) throws Exception;

    void deleteStudent (int id) throws Exception;
    Student updateStudent(Student student) throws Exception;
}
