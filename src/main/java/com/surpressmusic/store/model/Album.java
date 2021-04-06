package com.surpressmusic.store.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="album_id")
   private Integer id;

   @Column
   private String name;

   @Column(name="genre")
   private String genre;

   @OneToMany(mappedBy = "albums")
   private List<Song> songs;

}
