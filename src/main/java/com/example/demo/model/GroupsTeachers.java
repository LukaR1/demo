package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "groups_teachers")
@SequenceGenerator(name = "groupsTeachersIdSeq", sequenceName = "groups_Teachers_id_seq", allocationSize = 1)
public class GroupsTeachers {

    enum Gender {
        MALE,
        FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupsTeachersIdSeq")
    private Integer id;
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "gender")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Groups group;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "teacher_id",referencedColumnName = "id",insertable = false,updatable = false)
//    private Teachers teacher;
}
