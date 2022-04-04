package com.example.demo.controller;

import com.example.demo.model.Teachers;
import com.example.demo.service.TeachersService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(tags = {"teachers"}, summary = "მასწავლებლების სია")
    public List<Teachers> getTeachers(String teachers) {
        return teachersService.getTeachers(teachers);
    }

    @PostMapping
    public ResponseEntity<Teachers> addTeachers(@RequestBody Teachers teachers) {
        Teachers Teachers = teachersService.addTeachers(teachers);
        return ResponseEntity.status(201).body(Teachers);
    }

    @PutMapping("{id}")
    public ResponseEntity<Teachers> updateTeachers(@PathVariable int id,
                                                   @RequestBody Teachers teachers) {
        try {
            teachers.setId(id);
            Teachers dbTeachers = teachersService.updateTeachers(teachers);
            return ResponseEntity.ok(dbTeachers);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTeachers(@PathVariable int id) {
        try {
            teachersService.deleteTeachers(id);
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
