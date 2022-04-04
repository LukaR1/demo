package com.example.demo.service;

import com.example.demo.model.Groups;
import com.example.demo.repository.GroupsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupsServiceImpl implements GroupsService{
    private final GroupsRepository groupsRepository;

    public GroupsServiceImpl(GroupsRepository groupsRepository) {
        this.groupsRepository = groupsRepository;
    }

    @Override
    public Groups add(Groups groups) {
        return groupsRepository.save(groups);
    }

    @Override
    public List<Groups> get(String Groups) {
        return groupsRepository.findAll();
    }

    @Override
    public Groups get(int id) throws Exception {
        return groupsRepository.findById(id).orElseThrow(() -> new Exception("Group not found"));
    }

    @Override
    public void delete(int id) throws Exception {
        groupsRepository.delete(get(id));
    }

    @Override
    public Groups update(Groups groups) throws Exception {
        get(groups.getId());
        return groupsRepository.save(groups);
    }
}
