package com.surpressmusic.store.model.product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="album_id")
   private Integer id;

   @Column(name="title")
   private String title;

   @OneToOne
   @JoinColumn(name="artist_id")
   private Artist artist;

   @OneToOne
   @JoinColumn(name="genre_id")
   private Genre genre;

   @OneToMany
   @JoinColumn(name="song_id")
   private List<Song> songs;

   public Album() {}

   public Integer getId() {
      return id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Artist getArtist() {
      return artist;
   }

   public void setArtist(Artist artist) {
      this.artist = artist;
   }

   public Genre getGenre() {
      return genre;
   }

   public void setGenre(Genre genre) {
      this.genre = genre;
   }

   public List<Song> getSongs() {
      return songs;
   }

   public void setSongs(List<Song> songs) {
      this.songs = songs;
   }
}
