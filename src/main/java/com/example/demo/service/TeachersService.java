package com.example.demo.service;

import com.example.demo.model.*;

import java.util.List;

public interface TeachersService {
    Teachers add(Teachers teachers);

    List<Teachers> get(String Teachers);

    Teachers get(int id) throws Exception;

    void delete(int id) throws Exception;

    Teachers update(Teachers teachers) throws Exception;
}
