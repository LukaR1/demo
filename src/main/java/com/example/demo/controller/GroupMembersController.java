package com.example.demo.controller;

import com.example.demo.model.GroupMembers;
import com.example.demo.service.GroupMemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class GroupMembersController {
    private final GroupMemberService groupMemberService;

    @GetMapping
    @Operation(tags = {"GroupMembers"}, summary = "ჯგუფის წევრების სია")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USERS', 'MODER')")
    public List<GroupMembers> get(String groupMembers) {
        return groupMemberService.get(groupMembers);
    }

    @PostMapping
    @Operation(tags = {"GroupMembers"}, summary = "ჯგუფის წევრის დამატება")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<GroupMembers> add(@RequestBody GroupMembers groupMembers) {
        GroupMembers GroupMembers = groupMemberService.add(groupMembers);
        return ResponseEntity.status(201).body(GroupMembers);
    }

    @PutMapping("{id}")
    @Operation(tags = {"GroupMembers"}, summary = "ჯგუფის წევრის ინფორმაციის განახლება")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
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
    @Operation(tags = {"GroupMembers"}, summary = "ჯგუფის წევრის წაშლა")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            groupMemberService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("{id}")
    @Operation(tags = {"GroupMembers"}, summary = "ჯგუფის წევრის ID-ით ძებნა")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'MODER')")
    public ResponseEntity<GroupMembers> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(groupMemberService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
