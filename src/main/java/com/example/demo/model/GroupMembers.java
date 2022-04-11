package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "group_members")
@SequenceGenerator(name = "groupMemberIdSeq", sequenceName = "group_member_id_seq", allocationSize = 1)
public class GroupMembers implements Serializable {

    enum Gender {
        MALE,
        FEMALE
    }
    enum Type{
        STUDENT,
        TEACHER
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
    private Gender gender;
    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @JsonBackReference
    @JoinColumn(name = "group_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Groups members;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacherInfo")
    private List<Teachers> teacherInfo;


    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "studentInfo")
    private Set<Students> studentInfo;
//
//    @JsonManagedReference
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacherInfo")
//    private Set<Teachers> teacherInfo;

}
