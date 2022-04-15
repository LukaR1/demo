package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;



@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "teachers")
@SequenceGenerator(name = "teachersIdGenerator", sequenceName = "teachers_id_seq", allocationSize = 1)
public class Teachers  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentIdGenerator")
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(name = "personal_no")
    private String personalNo;
    private String  email;
    @Column (name = "birth_date")
    private Date birthDate;

    @JsonBackReference
    @JoinColumn(name = "id", referencedColumnName = "member_id", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private GroupMembers teacherInfo;


}
