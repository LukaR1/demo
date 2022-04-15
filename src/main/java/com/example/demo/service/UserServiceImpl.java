package com.example.demo.service;

import com.example.demo.domains.UserDomain;
import com.example.demo.domains.UserRole;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDomain add(UserDomain userDomain) {
        userDomain.setPassword(passwordEncoder.encode(userDomain.getPassword()));
        userRepository.save(userDomain);
        UserRole defaultRole = new UserRole();
        defaultRole.setRoleId(1);
        defaultRole.setUserId(userDomain.getId());
        defaultRole.setActive(true);
        userRoleRepository.save(defaultRole);
        return userDomain;
    }

    @Override
    public List<UserDomain> get(String Teachers) {
        return userRepository.findAll();
    }

    @Override
    public UserDomain get(int id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("Person not found"));
    }


    @Override
    public void delete(int id) throws Exception {
        userRepository.delete(get(id));
    }

    @Override
    public UserDomain update(UserDomain userDomain) throws Exception {
        get(userDomain.getId());
        return userRepository.save(userDomain);
    }
}
