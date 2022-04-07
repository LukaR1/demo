package com.example.demo.repository;

import com.example.demo.model.TeachersAndStudents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachersAndStudentsRepository extends JpaRepository<TeachersAndStudents, Integer> {
}
