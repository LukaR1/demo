package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClassServiceImpl implements ClassService{

    private final StudentRepository studentRepository;

    @Autowired
    public ClassServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudent(String Student) {
        return studentRepository.findAll();
    }
    @Override
    public Student get(int id) throws Exception{
        return studentRepository.findById(id).orElseThrow(()-> new Exception("Person not found"));
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        studentRepository.delete(get(id));

    }

    @Override
    public Student updateStudent(Student student) throws Exception {
        get(student.getId());
        return studentRepository.save(student);
    }
}
