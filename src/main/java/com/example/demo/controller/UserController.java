package com.example.demo.controller;

import com.example.demo.domains.UserDomain;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    @Operation(tags = {"Users"}, summary = "მომხმარებლების სია")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODER')")
    public List<UserDomain> get(String userDomain) {
        return userService.get(userDomain);
    }

    @PostMapping("/registration")
    @Operation(tags = {"Users"}, summary = "მომხმარებლის დამატება")
    public ResponseEntity<UserDomain> add(@RequestBody UserDomain userDomain) {
        UserDomain UserDomain = userService.add(userDomain);
        return ResponseEntity.status(201).body(UserDomain);
    }

    @PutMapping("{id}")
    @Operation(tags = {"Users"}, summary = "მომხმარებლის  განახლება")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserDomain> update(@PathVariable int id,
                                             @RequestBody UserDomain userDomain) {
        try {
            userDomain.setId(id);
            UserDomain dbUserDomain = userService.update(userDomain);
            return ResponseEntity.ok(dbUserDomain);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @Operation(tags = {"Users"}, summary = "მომხმარებლის წაშლა")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            userService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    @Operation(tags = {"Users"}, summary = "მომხმარებლის ID-ით ძებნა")
    @PreAuthorize("hasAnyAuthority('USER', 'MODER')")
    public ResponseEntity<UserDomain> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(userService.get(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
