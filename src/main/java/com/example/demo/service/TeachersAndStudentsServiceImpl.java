package com.example.demo.service;

import com.example.demo.model.TeachersAndStudents;
import com.example.demo.repository.TeachersAndStudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachersAndStudentsServiceImpl implements TeachersAndStudentsService {
    private final TeachersAndStudentsRepository teachersAndStudentsRepository;

    public TeachersAndStudentsServiceImpl(TeachersAndStudentsRepository teachersAndStudentsRepository) {
        this.teachersAndStudentsRepository = teachersAndStudentsRepository;
    }

    @Override
    public TeachersAndStudents add(TeachersAndStudents teachersAndStudents) {
        return teachersAndStudentsRepository.save(teachersAndStudents);
    }

    @Override
    public List<TeachersAndStudents> get(String TeachersAndStudents) {
        return teachersAndStudentsRepository.findAll();
    }

    @Override
    public TeachersAndStudents get(int id) throws Exception {
        return teachersAndStudentsRepository.findById(id).orElseThrow(()-> new Exception("members not found"));
    }

    @Override
    public void delete(int id) throws Exception {
        teachersAndStudentsRepository.delete(get(id));
    }

    @Override
    public TeachersAndStudents update(TeachersAndStudents teachersAndStudents) throws Exception {
        get(teachersAndStudents.getId());
        return teachersAndStudentsRepository.save(teachersAndStudents);
    }
}
