package com.example.demo.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


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
}
