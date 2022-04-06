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
@Table(name = "group_members")
@SequenceGenerator(name = "groupMemberIdSeq", sequenceName = "group_member_id_seq", allocationSize = 1)
public class GroupMembers {

    enum Gender {
        MALE,
        FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupMemberIdSeq")
    private Integer id;
    @Column(name = "member_id")
    private Integer memberId;
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "gender")
    @Enumerated(EnumType.ORDINAL)
    private Gender personType;

    @JsonBackReference
    @JoinColumn(name = "group_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Students member;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "member_id",referencedColumnName = "id",insertable = false,updatable = false)
//    private Students students;
}
