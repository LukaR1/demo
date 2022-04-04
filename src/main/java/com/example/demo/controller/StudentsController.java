package com.example.demo.controller;

import com.example.demo.model.Students;
import com.example.demo.service.StudentsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentsController {
    private final StudentsService studentsService;


    @GetMapping
    @Operation(tags = {"students"}, summary = "სტუდენტების სია")
    public List<Students> getStudents(String students) {
        return studentsService.getStudents(students);
    }

    @PostMapping
    public ResponseEntity<Students> addStudents(@RequestBody Students students) {
        Students Students = studentsService.addStudents(students);
        return ResponseEntity.status(201).body(Students);
    }

    @PutMapping("{id}")
    public ResponseEntity<Students> updateStudents(@PathVariable int id,
                                                  @RequestBody Students students) {
        try {
            students.setId(id);
            Students dbStudents = studentsService.updateStudents(students);
            return ResponseEntity.ok(dbStudents);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudents(@PathVariable int id) {
        try {
            studentsService.deleteStudents(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Students> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(studentsService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
