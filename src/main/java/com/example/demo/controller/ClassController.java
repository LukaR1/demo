package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.ClassService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class ClassController {
    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    @Operation(tags = {"student"}, summary = "სტუდენტების სია")
    public List<Student> getStudent(String student) {
        return classService.getStudent(student);
    }

    @PostMapping
    @Operation(tags = {"Products"}, summary = "ახალ პროდუქტის დამატება")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student Student = classService.addStudent(student);
        return ResponseEntity.status(201).body(Student);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,
                                                 @RequestBody Student student) {
        try {
            student.setId(id);
            Student dbStudent = classService.updateStudent(student);
            return ResponseEntity.ok(dbStudent);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        try {
            classService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(classService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
