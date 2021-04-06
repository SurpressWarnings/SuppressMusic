package com.surpressmusic.store.model;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="genre_id")
   private Integer id;

   @Column(name="genre")
   private GenreType genre;

   public Integer getId() {
      return id;
   }

   public GenreType getGenre() {
      return genre;
   }

   public void setGenre(GenreType genre) {
      this.genre = genre;
   }
}