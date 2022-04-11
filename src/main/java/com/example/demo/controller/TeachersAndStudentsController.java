package com.example.demo.controller;

import com.example.demo.model.TeachersAndStudents;
import com.example.demo.service.TeachersAndStudentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TeachersAndStudents")
@RequiredArgsConstructor
public class TeachersAndStudentsController {
    private final TeachersAndStudentsService teachersAndStudentsService;

    @GetMapping
    public List<TeachersAndStudents> get(String teachersAndStudents) {
        return teachersAndStudentsService.get(teachersAndStudents);
    }
    @PostMapping
    public ResponseEntity<TeachersAndStudents> add(@RequestBody TeachersAndStudents teachersAndStudents) {
        TeachersAndStudents TeachersAndStudents = teachersAndStudentsService.add(teachersAndStudents);
        return ResponseEntity.status(201).body(TeachersAndStudents);
    }
    @PutMapping("{id}")
    public ResponseEntity<TeachersAndStudents> update(@PathVariable int id,
                                           @RequestBody TeachersAndStudents teachersAndStudents) {
        try {
            teachersAndStudents.setId(id);
            TeachersAndStudents dbTeachersAndStudents = teachersAndStudentsService.update(teachersAndStudents);
            return ResponseEntity.ok(dbTeachersAndStudents);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            teachersAndStudentsService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<TeachersAndStudents> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(teachersAndStudentsService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
