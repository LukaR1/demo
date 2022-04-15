package com.example.demo.controller;

import com.example.demo.model.Teachers;
import com.example.demo.service.TeachersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeachersController {
    private final TeachersService teachersService;

    @GetMapping
    @Operation(tags = {"Teachers"}, summary = "მასწავლებლების სია")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'MODER')")
    public List<Teachers> get(String teachers) {
        return teachersService.get(teachers);
    }

    @PostMapping
    @Operation(tags = {"Teachers"}, summary = "მასწავლებლის დამატება")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Teachers> add(@RequestBody Teachers teachers) {
        Teachers Teachers = teachersService.add(teachers);
        return ResponseEntity.status(201).body(Teachers);
    }

    @PutMapping("{id}")
    @Operation(tags = {"Teachers"}, summary = "მასწავლებლის ინფორმაციის განახლება")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
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
    @Operation(tags = {"Teachers"}, summary = "მასწავლებლის წაშლა")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            teachersService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("{id}")
    @Operation(tags = {"Teachers"}, summary = "მასწავლებლის ID-ით ძებნა")
    @PreAuthorize("hasAnyAuthority('USER', 'MODER', 'ADMIN')")
    public ResponseEntity<Teachers> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(teachersService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
