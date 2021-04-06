package com.surpressmusic.store.model;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="song_id")
   private Integer id;

   @Column
   private String artist;

   @Column(name="song")
   private String songTitle;

   @Column
   private String format;

   @Column
   private String genre;

   @Column
   private float price;

   @ManyToOne
   @JoinColumn(name="album_id", nullable = true)
   private String album;

}
