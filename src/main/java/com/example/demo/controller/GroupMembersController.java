package com.example.demo.controller;

import com.example.demo.model.GroupMembers;
import com.example.demo.service.GroupMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class GroupMembersController {
    private final GroupMemberService groupMemberService;

    @GetMapping
    public List<GroupMembers> get(String groupMembers) {
        return groupMemberService.get(groupMembers);
    }

    @PostMapping
    public ResponseEntity<GroupMembers> add(@RequestBody GroupMembers groupMembers) {
        GroupMembers GroupMembers = groupMemberService.add(groupMembers);
        return ResponseEntity.status(201).body(GroupMembers);
    }

    @PutMapping("{id}")
    public ResponseEntity<GroupMembers> update(@PathVariable int id,
                                                      @RequestBody GroupMembers groupMembers) {
        try {
            groupMembers.setId(id);
            GroupMembers dbGroupMembers = groupMemberService.update(groupMembers);
            return ResponseEntity.ok(dbGroupMembers);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            groupMemberService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<GroupMembers> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(groupMemberService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
