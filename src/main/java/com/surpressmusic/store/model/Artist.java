package com.surpressmusic.store.model;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="artist_id", nullable = false)
   private Integer id;

   @Column(name="name", nullable = false)
   private String name;

   public Artist() {}

   public Integer getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
