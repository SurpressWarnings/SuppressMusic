package com.surpressmusic.store.model;

import com.surpressmusic.store.entity.products.Song;

public class SongInfo {

   private String id;
   private String title;
   private double price;

   public SongInfo() {}

   public SongInfo(Song song) {
      this.id = song.getId().toString();
      this.title = song.getSongTitle();
      this.price = song.getPrice();
   }

   // Using in JPA/Hibernate query
   public SongInfo(Long songId, String title, double price) {
      this.id = songId.toString();
      this.title = title;
      this.price = price;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
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
