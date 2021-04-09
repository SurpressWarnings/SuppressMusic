package com.surpressmusic.store.model;

public class OrderDetailInfo {

   private Integer id;

   private Integer songId;
   private String songTitle;

   private int quantity;
   private double price;
   private double amount;

   public OrderDetailInfo() {}

   // Using for JPA/Hibernate Query.
   public OrderDetailInfo(Integer id, Integer songId, //
                          String songTitle, int quantity,
                          double price, double amount) {
      this.id = id;
      this.songId = songId;
      this.songTitle = songTitle;
      this.quantity = quantity;
      this.price = price;
      this.amount = amount;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getsongId() {
      return songId;
   }

   public void setSongId(Integer songId) {
      this.songId = songId;
   }

   public String getSongTitle() {
      return songTitle;
   }

   public void setSongTitle(String songTitle) {
      this.songTitle = songTitle;
   }

   public int getQuantity() {
      return quantity;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public double getAmount() {
      return amount;
   }

   public void setAmount(double amount) {
      this.amount = amount;
   }
}
