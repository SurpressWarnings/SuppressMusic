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

   @Column(name="user_name", nullable = false)
   private String username;

   @Column(name="password", nullable = false)
   private String password;

   @Column(name="first_name", nullable = false)
   private String firstName;

   @Column(name="last_name", nullable = false)
   private String lastName;

   @Column(name="cc_number")
   private String ccNumber;

   @ManyToMany(cascade = CascadeType.MERGE)
   @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),   inverseJoinColumns = @JoinColumn(name = "role_id"))
   private Set<Role> roles;
}
