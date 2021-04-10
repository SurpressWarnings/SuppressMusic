package com.surpressmusic.store.model;

import com.surpressmusic.store.entity.products.Song;

public class SongInfo {

   private Integer id;
   private String title;
   private double price;

   public SongInfo() {}

   public SongInfo(Song song) {
      this.id = song.getId();
      this.title = song.getSongTitle();
      this.price = song.getPrice();
   }

   // Using in JPA/Hibernate query
   public SongInfo(Integer songId, String title, double price) {
      this.id = songId;
      this.title = title;
      this.price = price;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}
