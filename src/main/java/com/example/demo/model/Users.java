package com.example.demo.model;

import com.example.demo.domains.UserDomain;
import com.example.demo.domains.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;


@Setter
@Getter
public class Users implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean active;
    private List<UserRole> roles;

    private Collection<? extends GrantedAuthority> authorities;

    public Users(UserDomain userDomain, List<? extends GrantedAuthority> authorities) {
        id = userDomain.getId();
        username = userDomain.getUsername();
        password = userDomain.getPassword();
        firstName = userDomain.getFirstName();
        lastName = userDomain.getLastName();
        active = userDomain.getActive();
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
