package com.example.demo.service;

import com.example.demo.model.*;


import java.util.List;


public interface StudentsService {
    Students add(Students students);

    List<Students> get(String Student);

    Students get(int id) throws Exception;

    void delete(int id) throws Exception;

    Students update(Students students) throws Exception;
}

