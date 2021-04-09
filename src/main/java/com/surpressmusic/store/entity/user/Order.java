package com.surpressmusic.store.entity.user;

import com.surpressmusic.store.model.UserBill;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "order_id")
   private Integer id;

   @Column(name = "status")
   private String status;

   @Column(name = "order_num")
   private Long orderNum;

   @Column(name = "order_date")
   private Date orderDate;

   @Column(name = "total")
   private double total;

   @OneToOne
   @JoinColumn(name = "user_id")
   private User user;

   @OneToOne
   @JoinColumn(name = "bill_id")
   private UserBill userBill;

   public Order() {}

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getId() {
      return id;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public Long getOrderNum() {
      return orderNum;
   }

   public void setOrderNum(Long orderNum) {
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

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public UserBill getUserBill() {
      return userBill;
   }

   public void setUserBill(UserBill userBill) {
      this.userBill = userBill;
   }
}
