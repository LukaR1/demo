package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentRepository;

    @Autowired
    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentRepository = studentsRepository;
    }

    @Override
    public Students addStudents(Students students) {
        return studentRepository.save(students);
    }

    @Override
    public List<Students> getStudents(String Students) {
        return studentRepository.findAll();
    }

    @Override
    public Students get(int id) throws Exception {
        return studentRepository.findById(id).orElseThrow(() -> new Exception("Person not found"));
    }

    @Override
    public void deleteStudents(int id) throws Exception {
        studentRepository.delete(get(id));
    }

    @Override
    public Students updateStudents(Students students) throws Exception {
        get(students.getId());
        return studentRepository.save(students);
    }
}