package com.example.demo.domains;


import com.example.demo.model.GroupMembers;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@FieldNameConstants
@Table(name = "users")
@SequenceGenerator(name = "userIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
public class UserDomain implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdSeq")
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "users")
    private String username;
    private String password;
    @Column(name="first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Boolean active;

//    @JsonManagedReference
//    @OneToMany(cascade = CascadeType.REFRESH,mappedBy = "userDomain")
//    private Set<UserRole> userRole;


}


