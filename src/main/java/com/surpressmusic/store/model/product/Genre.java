package com.surpressmusic.store.model.product;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="genre_id")
   private Integer id;

   @Column(name="genre_type")
   private String genreType;

   public Integer getId() {
      return id;
   }

   public String getGenreType() {
      return genreType;
   }

   public void setGenreType(String genreType) {
      this.genreType = genreType;
   }
}