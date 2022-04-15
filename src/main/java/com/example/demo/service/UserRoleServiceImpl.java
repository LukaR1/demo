package com.example.demo.service;

import com.example.demo.domains.UserRole;
import com.example.demo.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService{

    private final UserRoleRepository userRoleRepository;

    @Override
    public UserRole add(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }


    @Override
    public List<UserRole> get(String userRole) {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole get(int id) throws Exception {
        return userRoleRepository.findById(id).orElseThrow(() -> new Exception("Person not found"));
    }


    @Override
    public void delete(int id) throws Exception {
        userRoleRepository.delete(get(id));
    }

    @Override
    public UserRole update(UserRole userRole) throws Exception {
        get(userRole.getId());
        return userRoleRepository.save(userRole);
    }
}
