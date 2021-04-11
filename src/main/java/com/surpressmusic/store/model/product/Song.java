package com.surpressmusic.store.model.product;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="song_id")
   private Integer id;

   @Column(name="song", nullable = false)
   private String songTitle;

   @Column
   private float price;

   @OneToOne
   @JoinColumn(name = "artist_id")
   private Artist artist;

   @OneToOne
   @JoinColumn(name = "format_id")
   private Format format;

   @OneToOne
   @JoinColumn(name ="genre_id")
   private Genre genre;

   @ManyToOne
   @JoinColumn(name="album_id")
   private Album album;

   public Integer getId() {
      return id;
   }

   public Artist getArtist() {
      return artist;
   }

   public void setArtist(Artist artist) {
      this.artist = artist;
   }

   public String getSongTitle() {
      return songTitle;
   }

   public void setSongTitle(String songTitle) {
      this.songTitle = songTitle;
   }

   public float getPrice() {
      return price;
   }

   public void setPrice(float price) {
      this.price = price;
   }

   public Format getFormat() {
      return format;
   }

   public void setFormat(Format format) {
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
}
