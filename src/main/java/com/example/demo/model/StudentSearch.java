package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class StudentSearch {

    private String firstName;
    private String lastName;
    private Date birthDateFrom;
    private Date birthDateTo;
}

