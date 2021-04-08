package com.surpressmusic.store.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="role_id")
   private Integer id;

   @Column(name="role_type")
   private String roleType;

   public Integer getId() {
      return id;
   }

   public String getRoleType() {
      return roleType;
   }

   public void setRoleType(String roleType) {
      this.roleType = roleType;
   }
}
