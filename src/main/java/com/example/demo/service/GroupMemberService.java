package com.example.demo.service;

import com.example.demo.model.GroupMembers;


import java.util.List;

public interface GroupMemberService {

    GroupMembers add(GroupMembers groupMembers);

    List<GroupMembers> get(String GroupMembers);

    GroupMembers get(int id) throws Exception;

    void delete(int id) throws Exception;

    GroupMembers update(GroupMembers groupMembers) throws Exception;
}
