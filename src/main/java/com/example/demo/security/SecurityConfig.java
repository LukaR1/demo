package com.example.demo.security;

import com.example.demo.domains.UserRole;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;


    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            var user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("user:" + username + " not found"));

            var authorities = userRoleRepository.findAllByUserId(user.getId())
                    .stream()
                    .map(userRole -> userRole.getRoleInfo().getRoleName())
                    .map(SimpleGrantedAuthority::new)
                    .toList();

            return new Users(user, authorities);
        };

    }
}