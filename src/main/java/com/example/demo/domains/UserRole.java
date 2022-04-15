package com.example.demo.domains;

import com.example.demo.model.Groups;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "user_role")
@SequenceGenerator(name = "userRoleIdSeq", sequenceName = "user_role_id_seq", allocationSize = 1)
public class UserRole implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userRoleIdSeq")


    private Integer id;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "user_id")
    private Integer userId;
    private Boolean active;


//    @JsonBackReference
//    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
//    @ManyToOne(cascade = CascadeType.REFRESH)
//    private UserDomain userDomain;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Roles roleInfo;
}


