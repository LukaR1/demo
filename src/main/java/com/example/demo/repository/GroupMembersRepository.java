package com.example.demo.repository;

import com.example.demo.model.GroupMembers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMembersRepository extends JpaRepository<GroupMembers, Integer> {
}
