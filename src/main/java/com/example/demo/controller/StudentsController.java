package com.example.demo.controller;

import com.example.demo.model.StudentSearch;
import com.example.demo.model.Students;
import com.example.demo.service.StudentsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentsController {
    private final StudentsService studentsService;

    @GetMapping
    @Operation(tags = {"Students"}, summary = "სტუდენტების სია")
    @PreAuthorize("hasAuthority('USER')")
    public List<Students> get(String students) {
        return studentsService.get(students);
    }

    @PostMapping
    @Operation(tags = {"Students"}, summary = "სტუდენტის დამატება")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Students> add(@RequestBody Students students) {
        Students Students = studentsService.add(students);
        return ResponseEntity.status(201).body(Students);
    }

    @PutMapping("{id}")
    @Operation(tags = {"Students"}, summary = "სტუდენტის ინფოარმაციის განახლება")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Students> update(@PathVariable int id,
                                                  @RequestBody Students students) {
        try {
            students.setId(id);
            Students dbStudents = studentsService.update(students);
            return ResponseEntity.ok(dbStudents);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @Operation(tags = {"Students"}, summary = "სტუდენტის წაშლა")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            studentsService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    @Operation(tags = {"Students"}, summary = "სტუდენტების ID-ით ძებნა")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Students> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(studentsService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("search")
    @Operation(tags = {"Students"}, summary = "სტუდენტების დინამიური ძებნა")
    @PreAuthorize("hasAuthority('USER')")
    public List<Students> getStudents(@RequestBody StudentSearch params){
        return studentsService.getStudents(params);
    }
}
