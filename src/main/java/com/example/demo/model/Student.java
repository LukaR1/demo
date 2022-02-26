package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "student")
@SequenceGenerator(name = "studentIdGenerator", sequenceName = "student_id_seq", allocationSize = 1)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentIdGenerator")
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(name = "personal_no")
    private Integer personalNo;
    @Column (name = "email")
    private String  email;
    @Column (name = "birth_date")
    private LocalDate birthDate;
}
