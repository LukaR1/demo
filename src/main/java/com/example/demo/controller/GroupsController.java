package com.example.demo.controller;


import com.example.demo.model.Groups;
import com.example.demo.model.Students;
import com.example.demo.model.Teachers;
import com.example.demo.repository.GroupsRepository;
import com.example.demo.repository.StudentsRepository;
import com.example.demo.repository.TeachersRepository;
import com.example.demo.service.GroupsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupsController {
    private final GroupsService groupsService;


    private final GroupsRepository groupsRepository;
    private final StudentsRepository studentsRepository;
    private final TeachersRepository teachersRepository;

    @GetMapping
    @Operation(tags = {"groups"}, summary = "ჯგუფების სია")
    public List<Groups> get(String groups) {
        return groupsService.get(groups);
    }

    @PostMapping
    public ResponseEntity<Groups> add(@RequestBody Groups groups) {
        Groups Groups = groupsService.add(groups);
        return ResponseEntity.status(201).body(Groups);
    }

    @PutMapping("{id}")
    public ResponseEntity<Groups> update(@PathVariable int id,
                                         @RequestBody Groups groups) {
        try {
            groups.setId(id);
            Groups dbGroups = groupsService.update(groups);
            return ResponseEntity.ok(dbGroups);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            groupsService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Groups> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(groupsService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{groupId}/students/{memberId}")
    Groups enrollStudentsToGroups(
            @PathVariable long groupId,
            @PathVariable long memberId
    ) {
        Groups groups = groupsRepository.findById((int) groupId)
                .orElseThrow(() -> new RuntimeException("ERROR"));
        Students students = studentsRepository.findById((int) memberId)
                .orElseThrow(() -> new RuntimeException("ERROR"));
        groups.enrollStudents(students);
        return groupsRepository.save(groups);
    }

    @PutMapping("/{groupId}/teachers/{teachersId}")
    Groups assignTeachersToGroups(
            @PathVariable long groupId,
            @PathVariable long teachersId
    ) {
        Groups groups = groupsRepository.findById((int) groupId)
                .orElseThrow(() -> new RuntimeException("ERROR"));
        Teachers teachers = teachersRepository.findById((int) teachersId)
                .orElseThrow(() -> new RuntimeException("ERROR"));
        groups.assignTeachers(teachers);
        return groupsRepository.save(groups);
    }
}
