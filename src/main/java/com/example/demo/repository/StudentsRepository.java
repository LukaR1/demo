package com.example.demo.repository;

import com.example.demo.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentsRepository extends JpaRepository<Students, Integer>, JpaSpecificationExecutor<Students> {
}
