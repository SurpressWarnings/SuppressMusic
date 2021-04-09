package com.surpressmusic.store.entity.user;

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

   // To be implemented in the future
//   @ManyToOne
//   @JoinColumn(name = "album_id")
//   private Album album;

   @Column(name = "quantity")
   private int quantity;

   @Column(name = "price")
   private double price;

   @Column(name = "quantity_total")
   private double quantityTotal;

   public OrderDetail() {
      // empty constructor
   }

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

   public double getQuantityTotal() {
      return quantityTotal;
   }

   public void setQuantityTotal(double quantityTotal) {
      this.quantityTotal = quantityTotal;
   }
}
