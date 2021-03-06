package com.example.demo.service;


import com.example.demo.model.Teachers;
import com.example.demo.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachersServiceImpl implements TeachersService{

    private final TeachersRepository teachersRepository;

    @Autowired
    public TeachersServiceImpl(TeachersRepository teachersRepository) {
        this.teachersRepository = teachersRepository;
    }


    @Override
    public Teachers add(Teachers teachers) {
        return teachersRepository.save(teachers);
    }

    @Override
    public List<Teachers> get(String Teachers) {
        return teachersRepository.findAll();
    }

    @Override
    public Teachers get(int id) throws Exception {
        return teachersRepository.findById(id).orElseThrow(()-> new Exception("Person not found"));
    }

    @Override
    public void delete(int id) throws Exception {
        teachersRepository.delete(get(id));
    }

    @Override
    public Teachers update(Teachers teachers) throws Exception {
        get(teachers.getId());
        return teachersRepository.save(teachers);
    }
}
