package com.surpressmusic.store.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="album_id", nullable = false)
   private Integer id;

   @Column(name="title", nullable = false)
   private String title;

   @Column(name="artist", nullable = false)
   private String artist;
   
   @OneToOne
   @JoinTable(name="album_genre", joinColumns = @JoinColumn(name="album_id"),
      inverseJoinColumns = @JoinColumn(name="genre_id"))
   private Genre genre;

   @OneToMany
   @JoinColumn(name="song_id", nullable = true)
   private List<Song> songs;

}
