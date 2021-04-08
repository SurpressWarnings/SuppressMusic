package com.surpressmusic.store.model;

abstract class Product {
   private float price;

   public void setPrice(float price) {
      this.price = price;
   }

   public float getPrice() {
      return price;
   }
}
