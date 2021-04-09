package com.surpressmusic.store.model;

import com.surpressmusic.store.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "user_billing")
public class UserBill {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column("bill_id")
   private int id;

   @Column(name = "street_address", nullable = false)
   private String streetAddress;

   @Column(name = "city", nullable = false)
   private String city;

   @Column(name = "state", nullable = false)
   private String state;

   @Column(name = "zipcode", nullable = false)
   private String zipcode;

   @Column(name = "phone_number", nullable = false)
   private String phoneNumber;

   @OneToOne
   @JoinColumn(name = "user_id")
   private User user;

   public UserBill(){}

   public int getId() {
      return id;
   }

   public String getStreetAddress() {
      return streetAddress;
   }

   public void setStreetAddress(String streetAddress) {
      this.streetAddress = streetAddress;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getZipcode() {
      return zipcode;
   }

   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }
}
