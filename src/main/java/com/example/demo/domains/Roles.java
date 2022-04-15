package com.example.demo.domains;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@FieldNameConstants
@Table(name = "roles")
@SequenceGenerator(name = "rolesIdSeq", sequenceName = "roles_id_seq", allocationSize = 1)
public class Roles {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolesIdSeq")
    private Integer id;
    @Column(name = "role_name")
    private String roleName;

//    @JsonBackReference
//    @JoinColumn(name = "id", referencedColumnName = "role_id", insertable = false, updatable = false)
//    @OneToOne(cascade = CascadeType.ALL)
//    private UserRole userRole;
}
