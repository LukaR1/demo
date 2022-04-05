package com.example.demo.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "groups")
@SequenceGenerator(name = "groupsIdGenerator", sequenceName = "groups_id_seq", allocationSize = 1)
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupsIdGenerator")
    private Integer id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "group_no")
    private String groupNo;


    @ManyToMany
    @JoinTable(
            name = "students_enrolled",
            joinColumns = @JoinColumn (name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Students> enrolledStudent = new HashSet<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teachers_id", referencedColumnName = "id")
    private Teachers teachers;


    public void enrollStudents(Students students) {
        enrolledStudent.add(students);
    }

    public void assignTeachers(Teachers teachers) {
        this.teachers = teachers;
    }
}
