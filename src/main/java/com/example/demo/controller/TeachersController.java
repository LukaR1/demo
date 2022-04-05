package com.example.demo.controller;

import com.example.demo.model.Teachers;
import com.example.demo.service.TeachersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeachersController {
    private final TeachersService teachersService;

    @GetMapping
    public List<Teachers> get(String teachers) {
        return teachersService.get(teachers);
    }

    @PostMapping
    public ResponseEntity<Teachers> add(@RequestBody Teachers teachers) {
        Teachers Teachers = teachersService.add(teachers);
        return ResponseEntity.status(201).body(Teachers);
    }

    @PutMapping("{id}")
    public ResponseEntity<Teachers> update(@PathVariable int id,
                                                   @RequestBody Teachers teachers) {
        try {
            teachers.setId(id);
            Teachers dbTeachers = teachersService.update(teachers);
            return ResponseEntity.ok(dbTeachers);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            teachersService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Teachers> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(teachersService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
