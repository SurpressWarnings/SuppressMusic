package com.surpressmusic.store.model.shopping;

import com.surpressmusic.store.model.user.User;
import com.surpressmusic.store.model.user.UserBilling;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "order_id")
   private Integer id;

   @Column(name = "status")
   private String status;

   @Column(name = "total")
   private float total;

   @ElementCollection
   private List<String> userBilling = new ArrayList<>();

   @ElementCollection
   private List<Item> items = new ArrayList<>();

   @OneToOne
   @JoinColumn(name = "user_id")
   private User user;

   public Order(){}

   public Integer getId() {
      return id;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public float getTotal() {
      return total;
   }

   public void setTotal(float total) {
      this.total = total;
   }

   public List<String> getUserBilling() {
      return userBilling;
   }

   public void setUserBilling(List<String> userBilling) {
      this.userBilling = userBilling;
   }

   public List<Item> getItems() {
      return items;
   }

   public void setItems(List<Item> items) {
      this.items = items;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }
}
