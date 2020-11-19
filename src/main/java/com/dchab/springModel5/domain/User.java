package com.dchab.springModel5.domain;

import javax.persistence.*;
import java.util.Set;
import java.util.StringTokenizer;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private  boolean active;

    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name= "user_role", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles;



}
