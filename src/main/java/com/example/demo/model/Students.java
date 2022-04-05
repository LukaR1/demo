package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "students")
@SequenceGenerator(name = "studentIdGenerator", sequenceName = "student_id_seq", allocationSize = 1)
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentIdGenerator")
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(name = "personal_no")
    private String personalNo;
    @Column (name = "email")
    private String  email;
    @Column (name = "birth_date")
    private Date birthDate;


    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudent")
    private Set<Groups> groups = new HashSet<>();
}
