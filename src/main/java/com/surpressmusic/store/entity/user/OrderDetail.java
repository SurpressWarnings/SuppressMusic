package com.surpressmusic.store.entity.user;

import com.surpressmusic.store.entity.products.Album;
import com.surpressmusic.store.entity.products.Song;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "order_detail_id")
   private Integer id;

   @ManyToOne
   @JoinColumn(name = "order_id")
   private Order order;

   @ManyToOne
   @JoinColumn(name = "song_id")
   private Song song;

   @ManyToOne
   @JoinColumn(name = "album_id")
   private Album album;

   @Column(name = "quantity")
   private int quantity;

   @Column(name = "price")
   private double price;

   @Column(name = "amount")
   private double amount;

   public OrderDetail() {}

   public Integer getId() {
      return id;
   }

   public Order getOrder() {
      return order;
   }

   public void setOrder(Order order) {
      this.order = order;
   }

   public Song getSong() {
      return song;
   }

   public void setSong(Song song) {
      this.song = song;
   }

   public Album getAlbum() {
      return album;
   }

   public void setAlbum(Album album) {
      this.album = album;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
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
