package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "students_enrolled")
@SequenceGenerator(name = "studentsEnrolledIdSeq", sequenceName = "student_enrolled_id_seq", allocationSize = 1)
public class StudentsEnrolled {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentsEnrolledIdSeq")
    private Integer id;
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "member_id")
    private Integer memberId;

}
