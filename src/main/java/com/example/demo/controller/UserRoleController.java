package com.example.demo.controller;


import com.example.demo.domains.UserRole;
import com.example.demo.service.UserRoleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-role")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;


    @GetMapping
    @Operation(tags = {"UserRole"})
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<UserRole> get(String userRole) {
        return userRoleService.get(userRole);
    }

    @PostMapping
    @Operation(tags = {"UserRole"})
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<UserRole> add(@RequestBody UserRole userRole) {
        UserRole UserRole = userRoleService.add(userRole);
        return ResponseEntity.status(201).body(UserRole);
    }

    @PutMapping("{id}")
    @Operation(tags = {"UserRole"})
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<UserRole> update(@PathVariable int id,
                                             @RequestBody UserRole userRole) {
        try {
            userRole.setId(id);
            UserRole dbUserRole = userRoleService.update(userRole);
            return ResponseEntity.ok(dbUserRole);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @Operation(tags = {"UserRole"})
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            userRoleService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    @Operation(tags = {"UserRole"})
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<UserRole> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(userRoleService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
