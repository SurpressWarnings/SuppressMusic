package com.surpressmusic.store.model.shopping;

import com.surpressmusic.store.model.product.Song;

public class Item {

   private Integer id;
   private Integer quantity;
   private String title;
   private String artist;
   private String format;
   private float price;
   private float subTotalPrice;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getQuantity() {
      return quantity;
   }

   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getArtist() {
      return artist;
   }

   public void setArtist(String artist) {
      this.artist = artist;
   }

   public float getPrice() {
      return price;
   }

   public void setPrice(float price) {
      this.price = price;
   }

   public float getSubTotalPrice() {
      return subTotalPrice;
   }

   public void setSubTotalPrice(float price) {
      this.subTotalPrice = price;
   }

   public Item() {
   }

   public Item(Song song, Integer quantity) {
      this.quantity = quantity;
      this.title = song.getSongTitle();
      this.artist = song.getArtist().getName();
      this.format = song.getFormat().getFormatType();
      this.id = song.getId();
      this.price = song.getPrice();
      this.subTotalPrice = song.getPrice() * quantity;
   }
}

