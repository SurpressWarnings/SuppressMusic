package com.surpressmusic.store.entity.user;

import com.surpressmusic.store.model.UserInfo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

   @Id
   @Column(name = "order_id", length = 50)
   private String id;

   @Column(name = "order_num")
   private int num;

   @Column(name = "status")
   private String status;

   @Column(name = "order_num")
   private int orderNum;

   @Column(name = "order_date")
   private Date orderDate;

   @Column(name = "total")
   private double total;

   @OneToOne
   @JoinColumn(name = "user_detail_id")
   private UserDetailsImpl userDetails;

   public Order() {}

   public void setId(String id) {
      this.id = id;
   }

   public String getId() {
      return id;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public int getOrderNum() {
      return orderNum;
   }

   public void setOrderNum(int orderNum) {
      this.orderNum = orderNum;
   }

   public Date getOrderDate() {
      return orderDate;
   }

   public void setOrderDate(Date orderDate) {
      this.orderDate = orderDate;
   }

   public double getTotal() {
      return total;
   }

   public void setTotal(double total) {
      this.total = total;
   }

   public UserDetailsImpl getUserDetails() {
      return userDetails;
   }

   public void setUserDetails(UserDetailsImpl userDetails) {
      this.userDetails = userDetails;
   }
}
