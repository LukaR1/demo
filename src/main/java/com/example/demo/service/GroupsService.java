package com.example.demo.service;

import com.example.demo.model.Groups;


import java.util.List;

public interface GroupsService {
    Groups add (Groups groups);

    List<Groups> get (String Groups);

    Groups get(int id) throws Exception;

    void delete (int id) throws Exception;

    Groups update (Groups groups) throws Exception;
}
