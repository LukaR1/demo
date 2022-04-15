package com.example.demo.controller;


import com.example.demo.model.Groups;
import com.example.demo.service.GroupsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupsController {
    private final GroupsService groupsService;

    @GetMapping
    @Operation(tags = {"Groups"}, summary = "ჯგუფების სია")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'MODER')")
    public List<Groups> get(String groups) {
        return groupsService.get(groups);
    }

    @PostMapping
    @Operation(tags = {"Groups"}, summary = "ჯგუფის დამატება")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Groups> add(@RequestBody Groups groups) {
        Groups Groups = groupsService.add(groups);
        return ResponseEntity.status(201).body(Groups);
    }

    @PutMapping("{id}")
    @Operation(tags = {"Groups"}, summary = "ჯგუფის ინფორმაციის განახლება")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
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
    @Operation(tags = {"Groups"}, summary = "ჯგუფის წაშლა")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            groupsService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    @Operation(tags = {"Groups"}, summary = "ჯგუფის ID-ით ძებნა")
    public ResponseEntity<Groups> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(groupsService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}


