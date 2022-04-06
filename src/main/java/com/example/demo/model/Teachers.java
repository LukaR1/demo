package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "teachers")
@SequenceGenerator(name = "teachersIdGenerator", sequenceName = "teachers_id_seq", allocationSize = 1)
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachersIdGenerator")
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(name = "personal_no")
    private String personalNo;
    private String  email;
    @Column (name = "birth_date")
    private Date birthDate;


//    @JsonIgnore
//    @OneToMany(mappedBy = "teachers")
//    private Set<Groups> groups = new HashSet<>();
}
