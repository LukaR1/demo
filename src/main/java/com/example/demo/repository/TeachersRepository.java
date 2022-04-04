package com.example.demo.repository;

import com.example.demo.model.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TeachersRepository extends JpaRepository <Teachers, Integer>{
}
