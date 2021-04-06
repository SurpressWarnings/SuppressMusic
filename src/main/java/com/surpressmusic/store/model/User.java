package com.surpressmusic.store.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="user_id")
   private Integer id;

   @Column(name="user_name")
   private String username;

   @Column(name="password")
   private String password;

   @Column(name="cc_number")
   private String ccNumber;

   @ManyToMany(cascade = CascadeType.MERGE)
   @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
   private Set<RoleType> roles;
}
