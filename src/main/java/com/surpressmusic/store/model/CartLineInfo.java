package com.surpressmusic.store.model;

public class CartLineInfo {

   private SongInfo songInfo;
   private int quantity;

   public CartLineInfo() {
      this.quantity = 0;
   }

   public SongInfo getSongInfo() {
      return songInfo;
   }

   public void setSongInfo(SongInfo songInfo) {
      this.songInfo = songInfo;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public double getAmount() {
      return this.songInfo.getPrice() * this.quantity;
   }
}
