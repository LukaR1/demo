package com.example.demo.service;

import com.example.demo.model.GroupMembers;
import com.example.demo.repository.GroupMembersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMemberServiceImpl implements GroupMemberService{
    private final GroupMembersRepository groupMembersRepository;

    public GroupMemberServiceImpl(GroupMembersRepository groupMembersRepository) {
        this.groupMembersRepository = groupMembersRepository;
    }

    @Override
    public GroupMembers add(GroupMembers groupMembers) {
        return groupMembersRepository.save(groupMembers);
    }

    @Override
    public List<GroupMembers> get(String GroupMembers) {
        return groupMembersRepository.findAll();
    }

    @Override
    public GroupMembers get(int id) throws Exception {
        return groupMembersRepository.findById(id).orElseThrow(() -> new Exception("Group member not found"));
    }

    @Override
    public void delete(int id) throws Exception {
        groupMembersRepository.delete(get(id));
    }

    @Override
    public GroupMembers update(GroupMembers groupMembers) throws Exception {
        get(groupMembers.getId());
        return groupMembersRepository.save(groupMembers);
    }
}
