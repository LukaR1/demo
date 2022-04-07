package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "students")
    private Set<GroupMembers> groupMembers;

//    @JsonManagedReference
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacherGroup")
//    private Set<Teachers> teacherGroup;
}
