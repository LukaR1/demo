package com.example.demo.service;

import com.example.demo.controller.StudentsController;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.criteria.Predicate;
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

    @Override
    public List<Students> getStudents(StudentSearch params) {
       return studentRepository.findAll(((root, query, cb) -> {
           Predicate predicate = cb.conjunction();
           if (StringUtils.isNotEmpty(params.getFirstName())){
               predicate = cb.and(predicate, cb.like(root.get("firstname"), params.getFirstName()+"%"));
           }
           if (params.getLastName() != null){
               predicate = cb.and(predicate, cb.equal(root.get("lastname"),params.getLastName()));
           }
           if (params.getBirthDateFrom() !=null) {
               predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("birthDate"), params.getBirthDateFrom()));
           }
           if (params.getBirthDateTo() !=null){
               predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("birthDate"), params.getBirthDateTo()));
           }
           return predicate;
       }));
    }
}
