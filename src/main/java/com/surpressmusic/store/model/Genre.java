package com.surpressmusic.store.model;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="genre_id")
   private Integer id;

   @Column(name="genre", nullable = false)
   private String genre;

   public Integer getId() {
      return id;
   }

   public String getGenre() {
      return genre;
   }

   public void setGenre(String genre) {
      this.genre = genre;
   }
}