package com.surpressmusic.store.entity.products;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="song_id")
   private Long id;

   @Column(nullable = false)
   private String artist;

   @Column(name="song", nullable = false)
   private String songTitle;

   @Column
   private String format;

   @OneToOne
   @JoinColumn(name ="genre_id")
   private Genre genre;

   @Column(nullable = false)
   private double price;

   @ManyToOne
   @JoinColumn(name="album_id")
   private Album album;

   public Long getId() {
      return id;
   }

   public String getArtist() {
      return artist;
   }

   public void setArtist(String artist) {
      this.artist = artist;
   }

   public String getSongTitle() {
      return songTitle;
   }

   public void setSongTitle(String songTitle) {
      this.songTitle = songTitle;
   }

   public String getFormat() {
      return format;
   }

   public void setFormat(String format) {
      this.format = format;
   }

   public Genre getGenre() {
      return genre;
   }

   public void setGenre(Genre genre) {
      this.genre = genre;
   }

   public Album getAlbum() {
      return album;
   }

   public void setAlbum(Album album) {
      this.album = album;
   }

   public String getAlbumTitle(Album album) {
      return album.getTitle();
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}
