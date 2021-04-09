package com.surpressmusic.store.model;

import java.util.Date;
import java.util.List;

public class OrderInfo {

   private String id;
   private Date orderDate;
   private int orderNum;
   private double amount;

   private String customerFirstName;
   private String customerLastName;
   private Address customerAddress;
   private String customerEmail;
   private String customerPhone;

   private List<OrderDetailInfo> details;

   public OrderInfo() {

   }

   // Using for Hibernate Query.
   public OrderInfo(String id, Date orderDate, int orderNum, double amount,
                    String customerFirstName, String customerLastName,
                    Address customerAddress, String customerEmail,
                    String customerPhone) {
      this.id = id;
      this.orderDate = orderDate;
      this.orderNum = orderNum;
      this.amount = amount;

      this.customerFirstName = customerFirstName;
      this.customerLastName = customerLastName;
      this.customerAddress = customerAddress;
      this.customerEmail = customerEmail;
      this.customerPhone = customerPhone;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public Date getOrderDate() {
      return orderDate;
   }

   public void setOrderDate(Date orderDate) {
      this.orderDate = orderDate;
   }

   public int getOrderNum() {
      return orderNum;
   }

   public void setOrderNum(int orderNum) {
      this.orderNum = orderNum;
   }

   public double getAmount() {
      return amount;
   }

   public void setAmount(double amount) {
      this.amount = amount;
   }

   public String getCustomerFirstName() {
      return customerFirstName;
   }

   public void setCustomerFirstName(String customerFirstName) {
      this.customerFirstName = customerFirstName;
   }

   public String getCustomerLastName() {
      return customerLastName;
   }

   public void setCustomerLastName(String customerLastName) {
      this.customerLastName = customerLastName;
   }

   public Address getCustomerAddress() {
      return customerAddress;
   }

   public void setCustomerAddress(Address customerAddress) {
      this.customerAddress = customerAddress;
   }

   public String getCustomerEmail() {
      return customerEmail;
   }

   public void setCustomerEmail(String customerEmail) {
      this.customerEmail = customerEmail;
   }

   public String getCustomerPhone() {
      return customerPhone;
   }

   public void setCustomerPhone(String customerPhone) {
      this.customerPhone = customerPhone;
   }

   public List<OrderDetailInfo> getDetails() {
      return details;
   }

   public void setDetails(List<OrderDetailInfo> details) {
      this.details = details;
   }
}
