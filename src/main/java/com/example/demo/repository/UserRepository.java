package com.example.demo.repository;

import com.example.demo.domains.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDomain, Integer> {

    Optional<UserDomain> findByUsername(String username);

}

