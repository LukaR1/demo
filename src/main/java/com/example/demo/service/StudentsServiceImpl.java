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
    public Students add(Students students) {
        return studentRepository.save(students);
    }

    @Override
    public List<Students> get(String Students) {
        return studentRepository.findAll();
    }

    @Override
    public Students get(int id) throws Exception {
        return studentRepository.findById(id).orElseThrow(() -> new Exception("Person not found"));
    }

    @Override
    public void delete(int id) throws Exception {
        studentRepository.delete(get(id));
    }

    @Override
    public Students update(Students students) throws Exception {
        get(students.getId());
        return studentRepository.save(students);
    }
}
