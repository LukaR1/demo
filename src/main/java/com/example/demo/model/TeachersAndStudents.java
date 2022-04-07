package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "teachers_and_students")
@SequenceGenerator(name = "teachersAndStudentsIdSeq", sequenceName = "teachers_and_students_id_seq", allocationSize = 1)
public class TeachersAndStudents {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachersAndStudentsIdSeq")
    private Integer id;
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "student_id")
    private Integer studentId;


}
