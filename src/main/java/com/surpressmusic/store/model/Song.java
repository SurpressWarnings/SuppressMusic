package com.surpressmusic.store.model;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="song_id")
   private Integer id;

   @Column(nullable = false)
   private String artist;

   @Column(name="song", nullable = false)
   private String songTitle;

   @Column
   private String format;

   @ManyToOne
   @JoinTable(name="song_genre", joinColumns = @JoinColumn(name="song_id"),
      inverseJoinColumns = @JoinColumn(name="genre_id"))
   private Genre genre;

   @Column(nullable = false)
   private float price;

   @ManyToOne
   @JoinColumn(name="album_id")
   private Album album;
}
